package game.view.institutionview;

import game.city.institution.IActionPanel;

import javax.swing.*;
import java.io.Serial;

public class InstitutionPanel extends JFrame implements IRActionPanel{
    IActionPanel actionPanel;

    @Serial
    private static final long serialVersionUID = 5648764998222329459L;

    public InstitutionPanel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        visual();
    }

    public void visual(){

    }

    public void openPanel(){
        setVisible(true);
    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}
