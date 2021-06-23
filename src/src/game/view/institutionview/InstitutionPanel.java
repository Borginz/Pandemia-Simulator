package game.view.institutionview;

import game.city.institution.IActionPanel;
import game.gameControl.IPauseTimer;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serial;

public class InstitutionPanel extends JFrame implements IPanel{
    IActionPanel actionPanel;
    IPauseTimer timerControl;

    @Serial
    private static final long serialVersionUID = 5648764998222329459L;

    public InstitutionPanel(){
        super();
        addWindowListener(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(350,150);
        setResizable(false);
        setLocationRelativeTo(null);
        visual();
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e){
        setVisible(false);
        timerControl.resumeTimer();
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }

    public void visual(){
    }

    public void openPanel(){
        setVisible(true);
        timerControl.pauseTimer();
        updateParameters();
    }

    public void updateParameters(){

    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }

    public void connect(IPauseTimer timerControl) {
        this.timerControl = timerControl;
    }
}
