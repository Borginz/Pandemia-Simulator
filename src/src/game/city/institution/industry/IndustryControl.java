package game.city.institution.industry;

import game.city.IUpdateParameters;
import game.city.institution.InstitutionControl;

public class IndustryControl extends InstitutionControl {
    int occupationPercentage;
    int moneyGenerated;
    int approvalInfluence;
    int populationPercentage;

    public IndustryControl(){
        super();
        occupationPercentage = 100;
        moneyGenerated = 10;
        approvalInfluence = 15;
        populationPercentage = 30;
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
        updatePopulationWorking();
    }

    public void connect(IUpdateParameters cityParameters){
        setCityParameters(cityParameters);
        updatePopulationWorking();
    }

    public void updatePopulationWorking(){
        getCityParameters().updatePopulationWorking((int)((((double)populationPercentage/100)*(((double)occupationPercentage)/100))*100), 'i');
    }

    public void update(){
        getCityParameters().updateMoney((int)(moneyGenerated*((double)occupationPercentage/100)));
    }
}
