package game.view;

import game.view.institutionview.InstitutionView;

public class View implements IUpdateAndAction{
    private CityView cityView;
    private BarView barView;
    private MayorView mayorView;

    public CityView getCityView(){
        return cityView;
    }

    public void openPanel() {

    }

    public void move(int x, int y) {

    }

    public void setMoney(int quantity) {

    }

    public void setApproval(double percentage) {

    }

    public void setInfected(int quantity) {

    }

    public void setImmunized(int quantity) {

    }
    public InstitutionView insert(int x, int y, char Char){
        return null;
    }
}
