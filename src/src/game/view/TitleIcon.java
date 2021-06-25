package game.view;

import javax.swing.*;

public class TitleIcon extends JLabel {

    public TitleIcon(String diretorio){
        super(new ImageIcon(diretorio + "sprites/title.png"));

    }
}
