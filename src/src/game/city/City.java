package game.city;

import game.city.institution.InstitutionControl;
import game.city.institution.butantan.ButantanControl;
import game.city.institution.hospital.HospitalControl;
import game.city.institution.house.HouseControl;
import game.city.institution.industry.IndustryControl;
import game.city.institution.shop.ShopControl;
import game.view.IUpdateBar;
import game.view.IWarningPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class City implements ICity, ActionListener {
    InstitutionControl[][] board;
    ArrayList<InstitutionControl> institutions;

    int sizeX;
    int sizeY;
    int initialPopulation;
    int population;
    int populationWorkingShop;
    int populationWorkingIndustry;
    int deaths;
    int immunized;
    int money;
    int infected;
    int mayorApprovalPercentage;
    int infectedNow;
    IWarningPanel warnPanel;

    ArrayList<HospitalControl> hospitals;

    double infectionRate;

    IUpdateBar barControl;

    public City(){
        population = initialPopulation = 10000;
        deaths = 0;
        immunized = 0;
        money = 100;
        infected = 0;
        mayorApprovalPercentage = 50;
        infectionRate = 0.00001;
        institutions = new ArrayList<>();
        hospitals = new ArrayList<>();


    }

    public void buildMatrix(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new InstitutionControl[sizeY][sizeX];
    }
    public InstitutionControl insert(int x, int y, char id){
        InstitutionControl institution = null;
        switch (id) {
            case ('H'):
                HospitalControl hospital = new HospitalControl();
                hospitals.add(hospital);
                institution = hospital;
                break;
            case ('S'):
                institution = new ShopControl();
                break;
            case ('I'):
                institution = new IndustryControl();
                break;
            case ('B'):
                institution = new ButantanControl();
                break;
            case ('C'):
                institution = new HouseControl();
                break;
            default:
                // TODO: THROW ERROR
                break;
        }

        if(board[y][x] == null){
            board[y][x] = institution; // TODO: THROW ERROR IF ITS ALREADY OCCUPIED
            institutions.add(institution);
        }
        return(institution);
    }

    public void connect(IUpdateBar barControl) {
        this.barControl = barControl;
    }

    public void startUpdate(){
        barControl.setMoney(money);
        barControl.setApproval(mayorApprovalPercentage);
        barControl.setInfected(infected);
        barControl.setImmunized(immunized);
        barControl.setDeaths(deaths);
    }


    public void updateMoney(int quantityDelta) {
        money += quantityDelta;
        barControl.setMoney(money);
        checkWinLose();
    }

    public void updateApproval(int quantityDelta) {
        mayorApprovalPercentage += quantityDelta;
        barControl.setApproval(mayorApprovalPercentage);
    }

    public void updateInfected(int quantityDelta) {
        infected += quantityDelta;
        for(HospitalControl h: hospitals){
            h.hospitalize(quantityDelta/hospitals.size());
        }
        barControl.setInfected(infected);
    }

    public void updateImmunized(int quantityDelta) {
        immunized += quantityDelta;
        barControl.setImmunized(immunized);
    }

    public void updateDeaths(int quantityDelta) {
        deaths += quantityDelta;
        population -= quantityDelta;
        barControl.setDeaths(deaths);
        barControl.setPopulation(population);
    }

    public void updatePopulationWorking(int percentage, char type) {
        if(type == 's') {
            populationWorkingShop = population * percentage;
        } else if(type == 'i'){
            populationWorkingIndustry = population * percentage;
        }
    }

    public int getPopulationActive() {
        return populationWorkingShop + populationWorkingIndustry - immunized - infected;
    }

    public void setPopulation(int population){
        this.population = initialPopulation = population;
    }

    private void checkWinLose(){
        if((double)population/(double)initialPopulation < 0.25){
            warnPanel.warn('l', "Você deixou 75% de sua população morrer!");
        }
        if(money < 0) {
            warnPanel.warn('l', "Você faliu!");
        }
        if(mayorApprovalPercentage <= 10){
            warnPanel.warn('l', "Você foi destituído do cargo!");
        }

        if((double)immunized/(double)population >= 0.75){
            warnPanel.warn('w', "Você imunizou 75% da população!");
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (InstitutionControl institution : institutions) institution.update();
        infectedNow = (int)((double)getPopulationActive()*infectionRate);
        updateInfected(infectedNow);
        checkWinLose();
    }

    public void connect(IWarningPanel warnPanel) {
        this.warnPanel = warnPanel;
    }
}

