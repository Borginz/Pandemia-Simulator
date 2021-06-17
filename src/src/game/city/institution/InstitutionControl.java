package game.city.institution;

import game.city.IUpdateParameters;
import game.gameControl.IPauseTimer;
import game.view.IUpdateBar;
import game.view.institutionview.IUpdateView;

public class InstitutionControl {
    IPauseTimer timerControl;
    IUpdateBar barControl;
    IUpdateView viewUpdate;
    IUpdateParameters cityParameters;

    public void connect(IUpdateView viewUpdate){
        this.viewUpdate = viewUpdate;
    }

    public void connect(IUpdateParameters cityParameters){
        this.cityParameters = cityParameters;
    }
}
