package game.view;

import javax.swing.*;
import java.awt.*;

public class BarView extends JPanel {
    private JProgressBar immunization;
    private JProgressBar approval;
    public BarView(){
        super();
        setLayout(new GridLayout(1,4,10,10));
        immunization = new JProgressBar(0,100);
        immunization.setValue(0);
        approval = new JProgressBar(0,100);
        approval.setValue(0);
        add(new JLabel("Imunização:"));
        add(immunization);
        add(new JLabel("Aprovação:"));
        add(approval);
    }
    public void setImmunizationBar(int value){
        immunization.setValue(value);
    }

    public void setApprovalBar(int value){
        approval.setValue(value);
    }
}
