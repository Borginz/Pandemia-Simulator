package game.view;

import javax.swing.*;
import java.awt.*;

public class ProgressView extends JPanel {
    private final JProgressBar infection;
    private final JLabel population;
    private final JLabel money;
    private final JLabel deaths;

    public ProgressView(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        infection = new JProgressBar(0,100);
        infection.setStringPainted(true);
        setInfectionBar(0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0;
        constraints.ipady = 30;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 4;
        add(infection, constraints);

        population = new JLabel();
        population.setHorizontalAlignment(JLabel.CENTER);
        setPopulation(0);
        constraints.weightx = 0.5;
        constraints.gridy = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        add(population, constraints);

        money = new JLabel();
        money.setHorizontalAlignment(JLabel.CENTER);
        setMoney(0);
        constraints.gridx = 2;
        add(money, constraints);

        deaths = new JLabel();
        deaths.setHorizontalAlignment(JLabel.CENTER);
        setDeaths(0);
        constraints.gridx = 3;
        add(deaths, constraints);

    }
    public void setInfectionBar(int value){
        infection.setValue(value); //TODO: DELAY
    }

    public void setPopulation(int value){
        infection.setMaximum(value);
        population.setText("População:" + value);
    }
    public void setMoney(int value){
        money.setText("Dinheiro: R$" + value + " Mil");
    }
    public void setDeaths(int value){
        deaths.setText("Mortes:" + value);
    }
}
