package com.view.institutionview.industry;

import com.view.institutionview.InstitutionIcon;
import javax.swing.*;
import java.util.Objects;

public class IndustryIcon extends InstitutionIcon {

    public IndustryIcon() {
        super(new ImageIcon(Objects.requireNonNull(IndustryIcon.class.getResource("/assets/industry.png"))));
    }
}
