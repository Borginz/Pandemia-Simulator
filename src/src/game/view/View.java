package game.view;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.lang.Math;

public class View extends JFrame implements IUpdateAndAction {
    private CityView cityView;
    private BarView barView;
    private ProgressView progressView;
    private String directory;
    private int population;

    @Serial
    private static final long serialVersionUID = -5552186889584090824L;

    public View(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cityView = new CityView();
        barView = new BarView();
        progressView = new ProgressView();
    }

    public void visual(){
        setSize(1024, 600);

        Container principalPanel = getContentPane();
        principalPanel.setLayout(new BorderLayout());

        principalPanel.add(barView, BorderLayout.PAGE_END);
        principalPanel.add(cityView, BorderLayout.CENTER);
        principalPanel.add(progressView, BorderLayout.PAGE_START);

        setVisible(true);
    }

    public void createView(){
        cityView.assembleView();
        visual();
    }

    public void setDirectory(String directory){
        this.directory = directory;
        cityView.setDirectory(directory);
    }

    public CityView getCityView(){
        return cityView;
    }

    public void openPanel() {
        cityView.openPanel();
    }

    public void moveMayor(int x, int y) {
        cityView.setMayorPos(x, y, cityView.isOccupied(x, y));
    }

    public void setPopulation(int quantity) {
        population = quantity;
        progressView.setPopulation(quantity);
    }

    public void setMoney(int quantity) {
        progressView.setMoney(quantity);
    }

    public void setApproval(double percentage) {
        barView.setApprovalBar((int)Math.ceil(percentage * 100));
    }

    public void setDeaths(int quantity) {
        progressView.setDeaths(quantity);
    }

    public void setInfected(int quantity) {
        progressView.setInfectionBar((quantity/population)*100);
    }

    public void setImmunized(int quantity) {
        barView.setImmunizationBar((quantity/population)*100);
    }

}
