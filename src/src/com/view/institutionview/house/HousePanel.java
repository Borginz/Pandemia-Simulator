package com.view.institutionview.house;

import com.city.institution.IActionPanel;
import com.view.institutionview.InstitutionPanel;
import javax.swing.*;
import java.awt.*;

public class HousePanel extends InstitutionPanel {
    IActionPanel actionPanel;
    private JButton stopAgglomeration;

    public HousePanel(){
        super();
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 1, 15, 15));
        stopAgglomeration = new JButton("Parar aglomeração");
        stopAgglomeration.addActionListener(e -> {
            actionPanel.stopAgglomeration();
            updateParameters();
            dispose();
        });
        principalPanel.add(new JLabel("Está tendo uma festa!"));
        principalPanel.add(stopAgglomeration);
    }

    public void openPanel(){
        if(actionPanel.getParameter('a') == 1) {
            setVisible(true);
            getTimerControl().pauseTimer();
            updateParameters();
        }
    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}
