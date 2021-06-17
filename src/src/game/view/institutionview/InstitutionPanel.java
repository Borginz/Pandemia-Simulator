package game.view.institutionview;

import game.city.institution.IActionPanel;

public class InstitutionPanel implements IRActionPanel{
    IActionPanel actionPanel;

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}
