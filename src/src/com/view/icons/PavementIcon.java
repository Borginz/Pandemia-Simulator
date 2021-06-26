package com.view.icons;

import javax.swing.*;
import java.util.Objects;

public class PavementIcon extends JLabel {

    public PavementIcon() {
        super(new ImageIcon(Objects.requireNonNull(PavementIcon.class.getResource("/assets/pavement.png"))));

    }
}
