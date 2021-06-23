package game.city;

import game.city.institution.InstitutionControl;
import game.city.institution.butantan.ButantanControl;
import game.city.institution.hospital.HospitalControl;
import game.city.institution.house.HouseControl;
import game.city.institution.industry.IndustryControl;
import game.city.institution.shop.ShopControl;
import game.gameControl.IPauseTimer;
import game.view.IUpdateBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class City implements ICity, ActionListener {
    InstitutionControl[][] board;
    ArrayList<InstitutionControl> institutions;
    int sizeX;
    int sizeY;
    int population;
    int deaths;
    int immunized;
    int money;
    int infected;
    int mayorApprovalPercentage;
    IUpdateBar barControl;

    public City(){
        population = 10000;
        deaths = 0;
        immunized = 0;
        money = 100;
        infected = 0;
        mayorApprovalPercentage = 50;
        institutions = new ArrayList<>();

    }

    public void buildMatrix(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new InstitutionControl[sizeY][sizeX];
    }
    public InstitutionControl insert(int x, int y, char id){
        InstitutionControl institution = switch (id) {
            case ('H') -> new HospitalControl();
            case ('S') -> new ShopControl();
            case ('I') -> new IndustryControl();
            case ('B') -> new ButantanControl();
            case ('C') -> new HouseControl();
            default -> null; // TODO: THROW ERROR
        };

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
    }

    public void updateApproval(int quantityDelta) {
        mayorApprovalPercentage += quantityDelta;
        barControl.setApproval(mayorApprovalPercentage);
    }

    public void updateInfected(int quantityDelta) {
        infected += quantityDelta;
        barControl.setInfected(infected);
    }

    public void updateImmunized(int quantityDelta) {
        immunized += quantityDelta;
        barControl.setImmunized(immunized);
    }

    public void updateDeaths(int quantityDelta) {
        deaths += quantityDelta;
        barControl.setDeaths(deaths);
    }

    public void setPopulation(int population){
        this.population = population;
    }

    public void actionPerformed(ActionEvent e) {
        for (InstitutionControl institution : institutions) institution.update();
    }
}

