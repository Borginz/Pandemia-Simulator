package game.view.institutionview.industry;

import game.view.institutionview.InstitutionView;

public class IndustryView extends InstitutionView {
    public IndustryView(){
        super();
    }

    public void createObjects(String directory){
        setInstitutionPanel(new IndustryPanel());
        setInstitutionIcon(new IndustryIcon(directory));
    }
}
