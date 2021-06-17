package game.gameController;

import game.city.City;
import game.mayor.Mayor;
import game.view.View;

public interface IConnectComponents {
    void connectComponents(City city, Mayor mayor, View view);
}
