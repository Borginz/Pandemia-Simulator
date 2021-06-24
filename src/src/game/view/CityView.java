package game.view;

import game.view.institutionview.InstitutionIcon;
import game.view.institutionview.InstitutionPanel;
import game.view.institutionview.InstitutionView;
import game.view.institutionview.butantan.ButantanIcon;
import game.view.institutionview.butantan.ButantanPanel;
import game.view.institutionview.hospital.HospitalIcon;
import game.view.institutionview.hospital.HospitalPanel;
import game.view.institutionview.house.HouseIcon;
import game.view.institutionview.house.HousePanel;
import game.view.institutionview.industry.IndustryIcon;
import game.view.institutionview.industry.IndustryPanel;
import game.view.institutionview.shop.ShopIcon;
import game.view.institutionview.shop.ShopPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CityView extends JPanel {
    private int sizeX;
    private int sizeY;
    private MayorIcon mayorIcon;
    private String directory;
    private InstitutionPanel[][] institutionPanels;
    private final ArrayList<InstitutionIcon> institutionIcons;

    JPanel[][] panelHolder;
    JPanel[][] panelHolderMayor;
    JPanel cityPanel;
    JPanel mayorPanel;

    public CityView(){
        super();
        institutionIcons = new ArrayList<>();
    }

    public void setSize(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        institutionPanels = new InstitutionPanel[sizeY][sizeX];
    }

    public void openPanel(){
        institutionPanels[mayorIcon.getY()][mayorIcon.getX()].openPanel();
    }

    public void assembleView(){
        setLayout(new OverlayLayout(this));
        cityPanel = new JPanel();
        cityPanel.setOpaque(false);
        cityPanel.setLayout(new GridLayout(sizeY,sizeX));
        mayorPanel = new JPanel();
        mayorPanel.setOpaque(false);
        mayorPanel.setLayout(new GridLayout(sizeY,sizeX));
        panelHolder = new JPanel[sizeY][sizeX];
        panelHolderMayor = new JPanel[sizeY][sizeX];
        setBorder(BorderFactory.createTitledBorder("Cidade"));

        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                panelHolder[y][x] = new JPanel();
                panelHolder[y][x].setOpaque(false);
                panelHolderMayor[y][x] = new JPanel();
                panelHolderMayor[y][x].setOpaque(false);
                cityPanel.add(panelHolder[y][x]);
                mayorPanel.add(panelHolderMayor[y][x]);
            }
        }
        for(InstitutionIcon i: institutionIcons){
            panelHolder[i.getPosY()][i.getPosX()].add(i);
        }

        panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].add(mayorIcon);

        add(mayorPanel);
        add(cityPanel);

    }

    public void setMayor(int x, int y, String directory){
        mayorIcon = new MayorIcon(x, y, directory);
    }

    public void setMayorPos(int x, int y){
        if(mayorIcon.getX()+x < sizeX && mayorIcon.getX()+x >= 0 && mayorIcon.getY()+y < sizeY && mayorIcon.getY()+y >= 0) {
            panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].removeAll();
            mayorIcon.moveX(x);
            mayorIcon.moveY(y);
            panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].add(mayorIcon);
            mayorIcon.setOccupied(institutionPanels[mayorIcon.getY()][mayorIcon.getX()] != null);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    public void setDirectory(String directory){
        this.directory = directory;
    }

    public InstitutionView insert(int x, int y, char id){
        InstitutionPanel institutionPanel;
        InstitutionIcon institutionIcon;
        InstitutionView institutionView;
        switch (id) {
            case ('H') -> {
                institutionPanel = new HospitalPanel();
                institutionIcon = new HospitalIcon(directory);
            }
            case ('S') -> {
                institutionPanel = new ShopPanel();
                institutionIcon = new ShopIcon(directory);
            }
            case ('I') -> {
                institutionPanel = new IndustryPanel();
                institutionIcon = new IndustryIcon(directory);
            }
            case ('B') -> {
                institutionPanel = new ButantanPanel();
                institutionIcon = new ButantanIcon(directory);
            }
            case ('C') -> {
                institutionPanel = new HousePanel();
                institutionIcon = new HouseIcon(directory);
            }
            default -> {
                institutionPanel = null;
                institutionIcon = null;
            } // TODO: THROW ERROR
        }
        institutionIcon.setPosX(x);
        institutionIcon.setPosY(y);
        institutionPanels[y][x] = institutionPanel;
        institutionIcons.add(institutionIcon);

        institutionView = new InstitutionView(institutionIcon, institutionPanel);

        return institutionView;
    }
}
