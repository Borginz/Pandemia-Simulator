package com.view.institutionview.hospital;

import com.view.institutionview.InstitutionIcon;
import javax.swing.*;
import java.util.Objects;

public class HospitalIcon extends InstitutionIcon {

    public HospitalIcon() {
        super(new ImageIcon(Objects.requireNonNull(HospitalIcon.class.getResource("/assets/hospital.png"))));
    }
}
