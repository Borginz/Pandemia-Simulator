package com.view;

import javax.swing.*;
import java.awt.*;

public class BarView extends JPanel {
    private final JProgressBar immunization;
    private final JProgressBar approval;
    public BarView(){
        super();
        setLayout(new GridLayout(1,4,10,10));
        UIManager.put("ProgressBar.selectionBackground",Color.BLACK);
        UIManager.put("ProgressBar.selectionForeground",Color.BLACK);

        immunization = new JProgressBar(0,100);
        immunization.setForeground(Color.GREEN);
        immunization.setStringPainted(true);
        immunization.setValue(0);

        approval = new JProgressBar(0,100);
        approval.setForeground(Color.GREEN);
        approval.setStringPainted(true);
        approval.setValue(0);
        JLabel immunizationLabel = new JLabel("Imunização:");
        immunizationLabel.setHorizontalAlignment(JLabel.CENTER);
        immunizationLabel.setFont(immunizationLabel.getFont().deriveFont(16.0f));
        JLabel approvalLabel = new JLabel("Aprovação:");
        approvalLabel.setHorizontalAlignment(JLabel.CENTER);
        approvalLabel.setFont(approvalLabel.getFont().deriveFont(16.0f));
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
