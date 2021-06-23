package game.view.institutionview.shop;

import game.city.institution.IActionPanel;
import game.view.institutionview.InstitutionPanel;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends InstitutionPanel {
    IActionPanel actionPanel;
    private JProgressBar occupation;
    private JTextField occupationPercentage;
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
        occupationPercentage = new JTextField("100", 0);
        defineOccupation = new JButton("Limitar ocupação");
        defineOccupation.addActionListener(e -> {
            actionPanel.limitOccupation(Integer.parseInt(occupationPercentage.getText()));
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
