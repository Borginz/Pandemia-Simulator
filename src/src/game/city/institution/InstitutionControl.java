package game.city.institution;

import game.city.IUpdateParameters;
import game.view.institutionview.IUpdateView;

public class InstitutionControl implements IInstitutionControl{
    private IUpdateView viewUpdate;
    private IUpdateParameters cityParameters;

    public void setCityParameters(IUpdateParameters cityParameters) {
        this.cityParameters = cityParameters;
    }

    public IUpdateView getViewUpdate() {
        return viewUpdate;
    }


    public IUpdateParameters getCityParameters() {
        return cityParameters;
    }

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

    public void limitOccupation(int percentage) {

    }

    public void stopAgglomeration() {

    }

    public int getParameter(char type) {
        return 0;
    }

    public void update(){

    }

}
