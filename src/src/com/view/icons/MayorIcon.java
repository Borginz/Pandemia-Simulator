package com.view.icons;

import javax.swing.*;
import java.util.Objects;

public class MayorIcon extends JLabel {
    ImageIcon occupied;
    ImageIcon normal;
    int x;
    int y;

    public MayorIcon(int x, int y) {
        super(new ImageIcon(Objects.requireNonNull(MayorIcon.class.getResource("/assets/mayor.png"))));
        this.x = x;
        this.y = y;
        this.normal = new ImageIcon(Objects.requireNonNull(MayorIcon.class.getResource("/assets/mayor.png")));
        this.occupied = new ImageIcon(Objects.requireNonNull(MayorIcon.class.getResource("/assets/mayorOccupied.png")));

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
