package game.city.institution.hospital;

import game.city.institution.InstitutionControl;

import java.util.Random;

public class HospitalControl extends InstitutionControl {
    int bedsOccupied;
    int bedsTotal;
    int moneyInvested;
    double bedPrice;
    int chanceDeath;
    double treatmentRate;
    double deathRate;
    Random random;

    public void setMoneyInvested(int moneyInvested) {
        this.moneyInvested = moneyInvested;
        System.out.println(moneyInvested);
        bedsTotalUpdate();
    }

    public HospitalControl(){
        super();
        bedsOccupied = 0;
        moneyInvested = 500;
        bedPrice = 0.5;
        chanceDeath = 2;
        treatmentRate = 0.01;
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
        bedsOccupied += quantity;
    }

    private void bedsTotalUpdate(){
        bedsTotal = (int)(moneyInvested / bedPrice);
    }

    public void invest(int money){
        moneyInvested += money;
        bedsTotalUpdate();
        getCityParameters().updateMoney(-money);
    }

    public void update(){
        if((double)bedsOccupied/(double)bedsTotal < 0.7 && (double)bedsOccupied > 1){
            chanceDeath = 20;
            getCityParameters().updateInfected(-(int)(bedsOccupied*treatmentRate));
            bedsOccupied -= bedsOccupied*treatmentRate;
        } else if((double)bedsOccupied/(double)bedsTotal >= 0.7 && (double)bedsOccupied/(double)bedsTotal <= 1.0) {
            chanceDeath = 50;
            getCityParameters().updateInfected(-(int)(bedsOccupied*treatmentRate/2));
            bedsOccupied -= bedsOccupied*treatmentRate/2;
        } else if ((double)bedsOccupied/(double)bedsTotal > 1.0){
            getCityParameters().updateDeaths(bedsOccupied - bedsTotal);
            bedsOccupied = bedsTotal;
        }
        int number = random.nextInt(100);
        if(number <= chanceDeath){
            getCityParameters().updateDeaths((int)(bedsOccupied*deathRate));
            bedsOccupied -= (int)(bedsOccupied*deathRate);
        }

    }
}
