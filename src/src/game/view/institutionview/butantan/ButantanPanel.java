package game.view.institutionview.butantan;

import game.city.institution.IActionPanel;
import game.view.institutionview.InstitutionPanel;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ButantanPanel extends InstitutionPanel {
    IActionPanel actionPanel;
    private JProgressBar vaccineDev; //quantos leitos tão ocupados
    private JFormattedTextField quantityInvested; //quanto dinheiro quer investir
    private JButton invest; // investe em mais leitos de acordo com quantityInvested
    private JLabel producedVaccine; // atualiza com a quantidade de leitos total


    public ButantanPanel(){
        super();
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 2, 15, 15));
        vaccineDev = new JProgressBar();
        vaccineDev.setValue(0);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);

        quantityInvested = new JFormattedTextField(formatter);
        quantityInvested.setValue(10);

        producedVaccine = new JLabel();
        invest = new JButton("Investir no desenv.");
        invest.addActionListener(e -> {
            actionPanel.invest(Integer.parseInt(quantityInvested.getText()));
            updateParameters();
        });
        principalPanel.add(new JLabel("Desenv. da vacina:"));
        principalPanel.add(vaccineDev);
        principalPanel.add(new JLabel("Vacinas produzidas:"));
        principalPanel.add(producedVaccine);
        principalPanel.add(quantityInvested);
        principalPanel.add(invest);
    }

    public void updateParameters(){
        vaccineDev.setValue(actionPanel.getParameter('d'));
        producedVaccine.setText(String.valueOf(actionPanel.getParameter('p')));
        if(!producedVaccine.getText().equals("0")){
            invest.setText("Investir na prod.");
        }
    }

    public void connect(IActionPanel actionPanel) {
        this.actionPanel = actionPanel;
    }
}