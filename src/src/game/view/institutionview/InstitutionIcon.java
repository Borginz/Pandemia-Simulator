package game.view.institutionview;

import javax.swing.*;
import java.io.Serial;

public class InstitutionIcon extends JLabel {

    @Serial
    private static final long serialVersionUID = -4743479130630783193L;

    public InstitutionIcon(String diretorio){
        super(new ImageIcon(diretorio));
    }
}
