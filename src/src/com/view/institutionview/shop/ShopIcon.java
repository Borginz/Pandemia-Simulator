package com.view.institutionview.shop;

import com.view.institutionview.InstitutionIcon;
import javax.swing.*;
import java.util.Objects;

public class ShopIcon extends InstitutionIcon {

    public ShopIcon() {
        super(new ImageIcon(Objects.requireNonNull(ShopIcon.class.getResource("/assets/shop.png"))));
    }
}
