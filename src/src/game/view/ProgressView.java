package game.view;

import javax.swing.*;
import java.awt.*;

public class ProgressView extends JPanel {
    private JProgressBar infection;
    private JLabel population;
    private JLabel money;
    private JLabel deaths;

    public ProgressView(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        infection = new JProgressBar(0,100);
        setInfectionBar(0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        add(infection, constraints);

        population = new JLabel();
        setPopulation(0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridx = 0;
        add(population, constraints);

        money = new JLabel();
        setMoney(0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridx = 1;
        add(money, constraints);

        deaths = new JLabel();
        setDeaths(0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridx = 2;
        add(deaths, constraints);

    }
    public void setInfectionBar(int value){
        infection.setValue(value);
    }

    public void setPopulation(int value){
        population.setText("População:" + value);
    }
    public void setMoney(int value){
        money.setText("Dinheiro: R$" + value + " Mil");
    }
    public void setDeaths(int value){
        deaths.setText("Mortes:" + value);
    }
}
