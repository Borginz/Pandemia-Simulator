package com.view.institutionview;

import com.city.institution.IActionPanel;
import com.gameControl.IPauseTimer;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class InstitutionPanel extends JFrame implements IInstitutionPanel {
    IActionPanel actionPanel;
    IPauseTimer timerControl;

    public IPauseTimer getTimerControl() {
        return timerControl;
    }

    private static final long serialVersionUID = 5648764998222329459L;

    public InstitutionPanel(){
        super();
        addWindowListener(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setSize(400,150);
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
