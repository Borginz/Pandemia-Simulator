package game.view;

import javax.swing.*;

public class MayorIcon extends JLabel {
    ImageIcon occupied;
    ImageIcon normal;
    int x;
    int y;

    public MayorIcon(int x, int y, String diretorio){
        super(new ImageIcon(diretorio + "sprites/mayor.png"));
        this.x = x;
        this.y = y;
        this.normal = new ImageIcon(diretorio + "sprites/mayor.png");
        this.occupied = new ImageIcon(diretorio + "sprites/mayorOccupied.png");

    }

    public int getX() {
        return x;
    }

    public void moveX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void moveY(int y) {
        this.y += y;
    }

    public void setOccupied(boolean status){
        if(status){
            this.setIcon(occupied);
        } else {
            this.setIcon(normal);
        }
    }
}
