package game.view;

import javax.swing.*;

public class MayorIcon extends JLabel {
    ImageIcon occupied;
    ImageIcon normal;
    int x;
    int y;

    public MayorIcon(int x, int y, String diretorio){
        super(diretorio + "sprites/mayor.png");
        this.x = x;
        this.y = y;
        this.normal = new ImageIcon(diretorio + "sprites/house.png");
        this.occupied = new ImageIcon(diretorio + "sprites/houseAgglomerating.png");

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOccupied(boolean status){
        if(status){
            this.setIcon(occupied);
        } else {
            this.setIcon(normal);
        }
    }
}
