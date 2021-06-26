package com.view.icons;

import javax.swing.*;
import java.util.Objects;

public class TitleIcon extends JLabel{

    public TitleIcon(){
        super(new ImageIcon(Objects.requireNonNull(TitleIcon.class.getResource("/assets/title.png"))));
    }
}
