package game.view.institutionview.house;

import game.view.institutionview.InstitutionView;

public class HouseView extends InstitutionView {

    public HouseView(){
        super();
    }

    public void createObjects(String directory){
        setInstitutionPanel(new HousePanel());
        setInstitutionIcon(new HouseIcon(directory));
    }
}

