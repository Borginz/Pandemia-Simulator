package game.view.institutionview;

public class InstitutionView  implements IUpdateView {
    private InstitutionIcon institutionIcon;
    private InstitutionPanel institutionPanel;
    private boolean isAgglomerating;

    public InstitutionView(){
        isAgglomerating = false;
    }

    public void setInstitutionIcon(InstitutionIcon institutionIcon) {
        this.institutionIcon = institutionIcon;
    }

    public void setInstitutionPanel(InstitutionPanel institutionPanel) {
        this.institutionPanel = institutionPanel;
    }

    public void createObjects(String directory){
        institutionPanel = new InstitutionPanel();
        institutionIcon = new InstitutionIcon(directory);
    }

    public InstitutionPanel getInstitutionPanel(){
        return institutionPanel;
    }
    public InstitutionIcon getInstitutionIcon(){
        return institutionIcon;
    }

    public void setAgglomeration(boolean isAgglomerating) {
        this.isAgglomerating = isAgglomerating;
    }

    public void setPanelParameter(char parameter, double bar, int number) {

    }
}
