package game.view.institutionview.shop;

import game.view.institutionview.InstitutionView;

public class ShopView extends InstitutionView {
    public ShopView(){
        super();
    }

    public void createObjects(String directory){
        setInstitutionPanel(new ShopPanel());
        setInstitutionIcon(new ShopIcon(directory));
    }
}
