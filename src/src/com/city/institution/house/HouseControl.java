package com.city.institution.house;

import com.city.institution.InstitutionControl;
import java.util.Random;
public class HouseControl extends InstitutionControl {
    private int timeAgglomerating;
    private boolean isAgglomerating;
    private final int approvalInfluence;
    private final int chanceAgglomerating;
    Random random;

    public HouseControl(){
        super();
        timeAgglomerating = 0;
        approvalInfluence = 1;
        chanceAgglomerating = 2;
        random = new Random();
    }

    public int getParameter(char type) {
        int parameter = 0;
        if(type == 'a')
            parameter = (isAgglomerating ? 1 : 0);
        return parameter;
    }

    public void update(){

        if(!isAgglomerating) {
            int number = random.nextInt(100);
            if(number <= chanceAgglomerating){
                getViewUpdate().setAgglomeration(true);
                isAgglomerating = true;
            }
        } else {
            timeAgglomerating++;

            if(timeAgglomerating == 3){
                getCityParameters().updateInfected(100);
            }
            if(timeAgglomerating == 9){
                getCityParameters().updateDeaths(30);
                isAgglomerating = false;
                timeAgglomerating = 0;
                getViewUpdate().setAgglomeration(false);
            }
        }
    }

    public void stopAgglomeration() {
        isAgglomerating = false;
        getViewUpdate().setAgglomeration(false);
        getCityParameters().updateApproval(-approvalInfluence);
        timeAgglomerating = 0;
    }
}
