package game.city;

import game.city.institution.InstitutionControl;
import game.gameControl.IPauseTimer;
import game.view.IUpdateBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class City implements ICity, ActionListener {
    InstitutionControl[][] board;
    InstitutionControl[] institutions;
    int sizeX;
    int sizeY;
    int population;
    int deaths;
    int immunized;
    int money;
    double infectedPercentage;
    double mayorApprovalPercentage;
    IUpdateBar barControl;
    IPauseTimer timerControl;



    public City(){
        population = 10000;
        deaths = 0;
        immunized = 0;
        money = 100000;
        infectedPercentage = 0;
        mayorApprovalPercentage = 0.5;


    }

    public void buildMatrix(int sizeX, int sizeY){



    }
    public InstitutionControl insert(int x, int y, char Char){
        return null;
    }

    public void connect(IPauseTimer timerControl) {

    }

    public void connect(IUpdateBar barControl) {

    }

    public void updateMoney(int quantityDelta) {

    }

    public void updateApproval(double multiplier) {

    }

    public void updateInfected(int quantityDelta) {

    }

    public void updateImmunized(int quantityDelta) {

    }

    public void actionPerformed(ActionEvent e) {
        for (InstitutionControl institution : institutions) institution.update();
    }
}

