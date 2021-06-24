package game.view.institutionview.hospital;

import game.city.institution.IActionPanel;
import game.view.institutionview.InstitutionPanel;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class HospitalPanel extends InstitutionPanel {
    IActionPanel actionPanel;
    private JProgressBar bedsOccupation; //quantos leitos tão ocupados
    private JFormattedTextField quantityInvested; //quanto dinheiro quer investir
    private JButton invest; // investe em mais leitos de acordo com quantityInvested
    private JLabel bedsQuantity; // atualiza com a quantidade de leitos total


    public HospitalPanel(){
        super();
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 2, 15, 15));
        bedsOccupation = new JProgressBar();
        bedsOccupation.setValue(0);


        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);

        quantityInvested = new JFormattedTextField(formatter);
        quantityInvested.setValue(10);

        bedsQuantity = new JLabel();
        invest = new JButton("Investir em leitos(mil)");
        invest.addActionListener(e -> {
            actionPanel.invest(Integer.parseInt(quantityInvested.getText()));
            updateParameters();
        });
        principalPanel.add(new JLabel("Quantidade de leitos:"));
        principalPanel.add(bedsQuantity);
        principalPanel.add(new JLabel("Leitos ocupados:"));
        principalPanel.add(bedsOccupation);
        principalPanel.add(quantityInvested);
        principalPanel.add(invest);
    }

    public void updateParameters(){
        bedsOccupation.setValue(actionPanel.getParameter('o'));
        bedsQuantity.setText(String.valueOf(actionPanel.getParameter('b')));
    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}

