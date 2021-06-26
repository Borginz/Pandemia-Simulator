package com.view.institutionview.shop;

import com.city.institution.IActionPanel;
import com.view.institutionview.InstitutionPanel;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ShopPanel extends InstitutionPanel {
    IActionPanel actionPanel;
    private JProgressBar occupation;
    private JFormattedTextField occupationPercentage;
    private JButton defineOccupation;

    public ShopPanel(){
        super();
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 2, 15, 15));
        occupation = new JProgressBar();
        occupation.setValue(0);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(100);
        formatter.setAllowsInvalid(false);

        occupationPercentage = new JFormattedTextField(formatter);
        occupationPercentage.setValue(100);

        defineOccupation = new JButton("Limitar ocupação");
        defineOccupation.addActionListener(e -> {
            actionPanel.limitOccupation((int)occupationPercentage.getValue());
            updateParameters();
        });
        principalPanel.add(new JLabel("Ocupação:"));
        principalPanel.add(occupation);
        principalPanel.add(occupationPercentage);
        principalPanel.add(defineOccupation);
    }

    public void updateParameters(){
        occupation.setValue(actionPanel.getParameter('o'));
    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}
