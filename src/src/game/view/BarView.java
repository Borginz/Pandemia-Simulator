package game.view;

import javax.swing.*;
import java.awt.*;

public class BarView extends JPanel {
    private final JProgressBar immunization;
    private final JProgressBar approval;
    public BarView(){
        super();
        setLayout(new GridLayout(1,4,10,10));
        immunization = new JProgressBar(0,100);
        immunization.setValue(0);
        approval = new JProgressBar(0,100);
        approval.setValue(0);
        JLabel immunizationLabel = new JLabel("Imunização:");
        immunizationLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel approvalLabel = new JLabel("Aprovação:");
        approvalLabel.setHorizontalAlignment(JLabel.CENTER);
        add(approvalLabel);
        add(approval);
        add(immunizationLabel);
        add(immunization);
    }
    public void setImmunizationBar(int value){
        immunization.setValue(value);
    }

    public void setApprovalBar(int value){
        approval.setValue(value);
    }
}
