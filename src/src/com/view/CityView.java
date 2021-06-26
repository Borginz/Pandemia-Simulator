package com.view;

import com.exceptions.InstitutionUnknownException;
import com.view.icons.MayorIcon;
import com.view.icons.PavementIcon;
import com.view.institutionview.InstitutionIcon;
import com.view.institutionview.InstitutionPanel;
import com.view.institutionview.InstitutionView;
import com.view.institutionview.butantan.ButantanIcon;
import com.view.institutionview.butantan.ButantanPanel;
import com.view.institutionview.hospital.HospitalIcon;
import com.view.institutionview.hospital.HospitalPanel;
import com.view.institutionview.house.HouseIcon;
import com.view.institutionview.house.HousePanel;
import com.view.institutionview.industry.IndustryIcon;
import com.view.institutionview.industry.IndustryPanel;
import com.view.institutionview.shop.ShopIcon;
import com.view.institutionview.shop.ShopPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CityView extends JPanel {
    private int sizeX;
    private int sizeY;
    private MayorIcon mayorIcon;
    private InstitutionPanel[][] institutionPanels;
    private final ArrayList<InstitutionIcon> institutionIcons;

    JPanel[][] panelHolder;
    JPanel[][] panelHolderMayor;
    JPanel backPanel;
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

    public void assembleView() throws IOException {
        setLayout(new OverlayLayout(this));
        backPanel = new JPanel();
        backPanel.setLayout(new BorderLayout());
        backPanel.setOpaque(false);
        cityPanel = new JPanel();
        cityPanel.setOpaque(false);
        cityPanel.setLayout(new GridLayout(sizeY,sizeX));
        mayorPanel = new JPanel();
        mayorPanel.setOpaque(false);
        mayorPanel.setLayout(new GridLayout(sizeY,sizeX));
        panelHolder = new JPanel[sizeY][sizeX];
        panelHolderMayor = new JPanel[sizeY][sizeX];
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));

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

        backPanel.add(new PavementIcon(), BorderLayout.PAGE_START);
        panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].add(mayorIcon);

        add(mayorPanel);
        add(cityPanel);
        add(backPanel);

    }

    public void setMayor(int x, int y) throws IOException{
        mayorIcon = new MayorIcon(x, y);
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

    public InstitutionView insert(int x, int y, char id) throws IOException, InstitutionUnknownException {
        InstitutionPanel institutionPanel;
        InstitutionIcon institutionIcon;
        InstitutionView institutionView;
        switch (id) {
            case ('H'): {
                institutionPanel = new HospitalPanel();
                institutionIcon = new HospitalIcon();
                break;
            }
            case ('S'): {
                institutionPanel = new ShopPanel();
                institutionIcon = new ShopIcon();
                break;
            }
            case ('I'): {
                institutionPanel = new IndustryPanel();
                institutionIcon = new IndustryIcon();
                break;
            }
            case ('B'): {
                institutionPanel = new ButantanPanel();
                institutionIcon = new ButantanIcon();
                break;
            }
            case ('C'): {
                institutionPanel = new HousePanel();
                institutionIcon = new HouseIcon();
                break;
            }
            default: {
                throw new InstitutionUnknownException();
            }
        }
        institutionIcon.setPosX(x);
        institutionIcon.setPosY(y);
        institutionPanels[y][x] = institutionPanel;
        institutionIcons.add(institutionIcon);

        institutionView = new InstitutionView(institutionIcon, institutionPanel);

        return institutionView;
    }
}
