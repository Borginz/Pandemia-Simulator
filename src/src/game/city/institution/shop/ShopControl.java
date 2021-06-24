package game.city.institution.shop;

import game.city.IUpdateParameters;
import game.city.institution.InstitutionControl;

public class ShopControl extends InstitutionControl {
    int occupationPercentage;
    int moneyGenerated;
    int approvalInfluence;

    public ShopControl(){
        super();
        occupationPercentage = 100;
        moneyGenerated = 10;
        approvalInfluence = 30;
    }

    public int getParameter(char type) {
        int parameter = 0;
        if(type == 'o')
            parameter = occupationPercentage;

        return parameter;
    }

    public void limitOccupation(int percentage) {
        getCityParameters().updateApproval((int)(((double)approvalInfluence/100)*(double)(percentage-occupationPercentage)));
        occupationPercentage = percentage;
    }

    public void connect(IUpdateParameters cityParameters){
        setCityParameters(cityParameters);
    }

    public int getOccupationPercentage(){
        return occupationPercentage;
    }

    public void update(){
        getCityParameters().updateMoney((int)(moneyGenerated*((double)occupationPercentage/100)));
    }
}
