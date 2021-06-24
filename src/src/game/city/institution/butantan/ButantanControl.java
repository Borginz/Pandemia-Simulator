package game.city.institution.butantan;

import game.city.institution.InstitutionControl;

import java.util.Random;

public class ButantanControl extends InstitutionControl {
    int vaccineDev;
    int producedVaccine;
    int moneyInvested;
    double vaccinePerMoney;
    double devMoney;
    boolean vaccineDeveloped;
    Random random;

    public ButantanControl(){
        super();
        vaccineDeveloped = false;
        vaccineDev = 0;
        producedVaccine = 0;
        moneyInvested = 0;
        vaccinePerMoney = 0.1;
        devMoney = 0.1;
        random = new Random();
    }

    public int getParameter(char type) {
        int parameter = 0;
        if(type == 'd')
            parameter = vaccineDev;
        if(type == 'p')
            parameter = producedVaccine;

        return parameter;
    }

    public void invest(int money){ // TODO: THROW ERROR IF MONEY IS NEGATIVE
        moneyInvested += money;
        getCityParameters().updateMoney(-money);
    }

    public void update(){
        if(!vaccineDeveloped){
            vaccineDev += moneyInvested*devMoney;
            if(vaccineDev >= 100)
                vaccineDeveloped = true;
        } else {
            producedVaccine += moneyInvested*vaccinePerMoney;
            getCityParameters().updateImmunized((int)(moneyInvested*vaccinePerMoney));
        }
    }
}
