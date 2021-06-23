package game.view.institutionview;

import javax.swing.*;
import java.io.Serial;

public class InstitutionIcon extends JLabel implements IUpdateView {
    int posX;
    int posY;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setAgglomeration(boolean status){

    }

    @Serial
    private static final long serialVersionUID = -4743479130630783193L;

    public InstitutionIcon(String diretorio){
        super(new ImageIcon(diretorio));
    }
}
