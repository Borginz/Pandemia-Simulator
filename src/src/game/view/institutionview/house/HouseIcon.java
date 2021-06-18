package game.view.institutionview.house;

import game.view.institutionview.InstitutionIcon;

import javax.swing.*;

public class HouseIcon extends InstitutionIcon {
    ImageIcon agglomerating;
    ImageIcon normal;

    public HouseIcon(String diretorio){
        super(diretorio + "sprites/house.png");
        this.normal = new ImageIcon(diretorio + "sprites/house.png");
        this.agglomerating = new ImageIcon(diretorio + "sprites/houseAgglomerating.png");

    }

    public void agglomerating(boolean status){
        if(status){
            this.setIcon(agglomerating);
        } else {
            this.setIcon(normal);
        }
    }
}
