package game.city.institution;

import game.city.IUpdateParameters;
import game.gameControl.IPauseTimer;
import game.view.IUpdateBar;
import game.view.institutionview.IUpdateView;

import java.awt.event.ActionEvent;

public class InstitutionControl implements IInstitutionControl{
    IUpdateView viewUpdate;
    IUpdateParameters cityParameters;

    public InstitutionControl(){

    }

    public void connect(IUpdateView viewUpdate){
        this.viewUpdate = viewUpdate;
    }

    public void connect(IUpdateParameters cityParameters){
        this.cityParameters = cityParameters;
    }

    public void invest(int quantity) {

    }

    public void limitOccupation(double percentage) {

    }

    public void stopAgglomeration() {

    }

    public void setAgglomeration(boolean isAgglomerating) {

    }

    public void setPanelParameter(char parameter, double bar, int number) {

    }

    public void update(){

    }

}
