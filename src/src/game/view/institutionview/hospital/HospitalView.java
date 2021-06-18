package game.view.institutionview.hospital;

import game.view.institutionview.InstitutionView;

public class HospitalView extends InstitutionView {

    public HospitalView(){
        super();
    }

    public void createObjects(String directory){
        setInstitutionPanel(new HospitalPanel());
        setInstitutionIcon(new HospitalIcon(directory));
    }
}
