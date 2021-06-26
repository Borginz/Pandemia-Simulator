package com.view.institutionview.butantan;

import com.view.institutionview.InstitutionIcon;
import javax.swing.*;
import java.util.Objects;

public class ButantanIcon extends InstitutionIcon {

    public ButantanIcon() {
        super(new ImageIcon(Objects.requireNonNull(ButantanIcon.class.getResource("/assets/butantan.png"))));
    }

}
