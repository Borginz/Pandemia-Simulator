package com.city;

import com.city.institution.InstitutionControl;
import com.city.institution.butantan.ButantanControl;
import com.city.institution.hospital.HospitalControl;
import com.city.institution.house.HouseControl;
import com.city.institution.industry.IndustryControl;
import com.city.institution.shop.ShopControl;
import com.exceptions.InstitutionUnknownException;
import com.gameControl.IPauseTimer;
import com.view.IUpdateBar;
import com.view.panels.WarningPanel;

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
    int deaths;
    int immunized;
    int money;
    int infected;
    int mayorApprovalPercentage;
    int infectedNow;
    int shopPopulationPercentage;
    int industryPopulationPercentage;
    WarningPanel warnPanel;

    ArrayList<HospitalControl> hospitals;
    ArrayList<ShopControl> shops;
    ArrayList<IndustryControl> industries;

    double infectionRate;

    IUpdateBar barControl;

    public City(){
        warnPanel = new WarningPanel();
        population = 10000;
        initialPopulation = 10000;
        deaths = 0;
        immunized = 0;
        money = 100;
        infected = 0;
        mayorApprovalPercentage = 50;
        infectionRate = 0.008;
        shopPopulationPercentage = 70;
        industryPopulationPercentage = 30;
        institutions = new ArrayList<>();
        hospitals = new ArrayList<>();
        shops = new ArrayList<>();
        industries = new ArrayList<>();
    }

    public void connectTimer(IPauseTimer timerControl){
        warnPanel.connect(timerControl);
    }
    public void buildMatrix(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new InstitutionControl[sizeY][sizeX];
    }
    public InstitutionControl insert(int x, int y, char id){
        InstitutionControl institution = null;
        try {
            switch (id) {
                case ('H'):
                    HospitalControl hospital = new HospitalControl();
                    hospital.setMoneyInvested(population / 20);
                    hospitals.add(hospital);
                    institution = hospital;
                    break;
                case ('S'):
                    ShopControl shop = new ShopControl();
                    shops.add(shop);
                    institution = shop;
                    break;
                case ('I'):
                    IndustryControl industry = new IndustryControl();
                    industries.add(industry);
                    institution = industry;
                    break;
                case ('B'):
                    institution = new ButantanControl();
                    break;
                case ('C'):
                    institution = new HouseControl();
                    break;
                default:
                    throw new InstitutionUnknownException();
            }

            board[y][x] = institution;
            institutions.add(institution);
        } catch (InstitutionUnknownException e){
            warnPanel.warn('f', "Instituição não reconhecida: seu arquivo CSV está correto?");
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

    public int getPopulationActive() {
        int populationActive = -immunized - infected;
        for(ShopControl s: shops){
            populationActive += (int)(((((double)(shopPopulationPercentage/shops.size())/100)*(((double)s.getOccupationPercentage()))/100))*population);
        }
        for(IndustryControl i: industries){
            populationActive += (int)(((((double) (industryPopulationPercentage /industries.size()) /100)*(((double)i.getOccupationPercentage()))/100))*population);
        }
        return populationActive;
    }

    public void setPopulation(int population){
        this.population = population;
        initialPopulation = population;
    }

    private void checkWinLose(){
        if((double)population/(double)initialPopulation < 0.75){
            warnPanel.warn('l', "Você deixou 25% de sua população morrer!");
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

}

