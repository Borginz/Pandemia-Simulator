package com.view.institutionview.house;

import com.view.institutionview.InstitutionIcon;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HouseIcon extends InstitutionIcon {
    ImageIcon agglomerating;
    ImageIcon normal;

    public HouseIcon() throws IOException {
        super(new ImageIcon(Objects.requireNonNull(HouseIcon.class.getResource("/assets/house.png"))));
        this.normal = new ImageIcon(Objects.requireNonNull(HouseIcon.class.getResource("/assets/house.png")));
        this.agglomerating = new ImageIcon(Toolkit.getDefaultToolkit().createImage(org.apache.commons.io.IOUtils.toByteArray(Objects.requireNonNull(HouseIcon.class.getResource("/assets/houseAgglomerating.gif")))));

    }

    public void setAgglomeration(boolean status){
        if(status){
            this.setIcon(agglomerating);
        } else {
            this.setIcon(normal);
        }
    }
}
