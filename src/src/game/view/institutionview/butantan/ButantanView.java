package game.view.institutionview.butantan;

import game.view.institutionview.InstitutionView;

public class ButantanView extends InstitutionView {

    public ButantanView(){
        super();
    }

    public void createObjects(String directory){
        setInstitutionPanel(new ButantanPanel());
        setInstitutionIcon(new ButantanIcon(directory));
    }
}
