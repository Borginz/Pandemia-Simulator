package game.view;

import javax.swing.*;
import java.awt.*;

public class TitleIcon extends JLabel {

    public TitleIcon(String diretorio){
        super(new ImageIcon(Toolkit.getDefaultToolkit().getImage(diretorio + "sprites/title.png")));

    }
}
