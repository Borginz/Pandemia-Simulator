package game.city.institution.hospital;

import game.city.institution.InstitutionControl;

import java.util.Random;

public class HospitalControl extends InstitutionControl {
    int bedsOccupied;
    int bedsTotal;
    int moneyInvested;
    int bedPrice;
    int chanceDeath;
    double treatmentRate;
    double deathRate;
    Random random;

    public HospitalControl(){
        super();
        bedsOccupied = 0;
        moneyInvested = 1000;
        bedPrice = 1;
        chanceDeath = 2;
        treatmentRate = 0.1;
        deathRate = 0.1;
        bedsTotalUpdate();
        random = new Random();
    }

    public int getParameter(char type) {
        int parameter = 0;
        if(type == 'o')
            parameter = (int)(((double)bedsOccupied/(double)bedsTotal)*100);
        if(type == 'b')
            parameter = bedsTotal;

        return parameter;
    }

    public void hospitalize(int quantity){
        if(bedsOccupied < bedsTotal)
            bedsOccupied += quantity;
    }

    private void bedsTotalUpdate(){
        bedsTotal = moneyInvested / bedPrice;
    }

    public void invest(int money){ // TODO: THROW ERROR IF MONEY IS NEGATIVE
        moneyInvested += money;
        treatmentRate += 0.001*money;
        bedsTotalUpdate();
        getCityParameters().updateMoney(-money);
    }

    public void update(){
        if((double)bedsOccupied/(double)bedsTotal < 0.7){
            chanceDeath = 20;
            getCityParameters().updateInfected(-(int)(bedsOccupied*treatmentRate));
            bedsOccupied -= bedsOccupied*treatmentRate;
        } else {
            chanceDeath = 50;
            getCityParameters().updateInfected(-(int)(bedsOccupied*treatmentRate/2));
            bedsOccupied -= bedsOccupied*treatmentRate/2;
        }
        int number = random.nextInt(100);
        if(number <= chanceDeath){
            getCityParameters().updateDeaths((int)(bedsOccupied*deathRate));
        }
        bedsOccupied -= bedsOccupied/10;
    }
}
