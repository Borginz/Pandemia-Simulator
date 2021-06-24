package game.view;

import game.view.institutionview.InstitutionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serial;

public class View extends JFrame implements IView {
    private final CityView cityView;
    private final BarView barView;
    private final ProgressView progressView;
    private String directory;
    private int population;
    private final WarningPanel warnPanel;

    public WarningPanel getWarnPanel() {
        return warnPanel;
    }

    @Serial
    private static final long serialVersionUID = -5552186889584090824L;

    public View(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cityView = new CityView();
        barView = new BarView();
        progressView = new ProgressView();
        warnPanel = new WarningPanel();
    }

    public void visual(){
        setSize(1230, 900);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new BorderLayout(15, 15));
        principalPanel.add(barView, BorderLayout.PAGE_END);
        principalPanel.add(cityView, BorderLayout.CENTER);
        principalPanel.add(progressView, BorderLayout.PAGE_START);

        setVisible(true);
    }

    public InstitutionView insert(int x, int y, char type){
        return cityView.insert(x, y, type);
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

    public void keyPress(int key){
        switch(key){
            case(KeyEvent.VK_W):
                cityView.setMayorPos(0, -1);
                break;
            case(KeyEvent.VK_A):
                cityView.setMayorPos(-1, 0);
                break;
            case(KeyEvent.VK_S):
                cityView.setMayorPos(0, 1);
                break;
            case(KeyEvent.VK_D):
                cityView.setMayorPos(1, 0);
                break;
            case(' '):
                try{
                    cityView.openPanel();
                } catch (NullPointerException e){
                    warnPanel.warn('e', "Não há instituições aqui!");
                }
                break;
            default:
                break;
        }
    }

    public void setPopulation(int quantity) {
        population = quantity;
        progressView.setPopulation(quantity);
    }

    public void setMoney(int quantity) {
        progressView.setMoney(quantity);
    }

    public void setApproval(int percentage) {
        barView.setApprovalBar(percentage);
    }

    public void setDeaths(int quantity) {
        progressView.setDeaths(quantity);
    }

    public void setInfected(int quantity) {
        progressView.setInfectionBar(quantity);
    }

    public void setImmunized(int quantity) {
        barView.setImmunizationBar((int)(((double)quantity/(double)population)*100));
    }

}
