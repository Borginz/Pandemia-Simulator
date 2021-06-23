package game.city.institution;

import game.city.IUpdateParameters;
import game.view.institutionview.IUpdateView;

public class InstitutionControl implements IInstitutionControl{
    private IUpdateView viewUpdate;
    private IUpdateParameters cityParameters;
    private boolean isAgglomerating;

    public IUpdateView getViewUpdate() {
        return viewUpdate;
    }

    public IUpdateParameters getCityParameters() {
        return cityParameters;
    }

    public InstitutionControl(){
        isAgglomerating = false;
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
        isAgglomerating = false;
        viewUpdate.setAgglomeration(false);
    }

    public int getParameter(char type) {
        return 0;
    }

    public void update(){

    }

}
