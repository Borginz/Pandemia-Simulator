package game.gameControl;

import game.city.City;
import game.mayor.Mayor;
import game.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Game implements IGame{
    Timer timer;
    City city;
    Mayor mayor;
    View view;

    public Game(){

    }

    public void connectComponents(City city, Mayor mayor, View view) {
        this.city = city;
        this.mayor = mayor;
        this.view = view;
    }

    public void runGame(){
        timer = new Timer(1000, city);
        resumeTimer();
    }

    public void pauseTimer() {
        timer.stop();
    }

    public void resumeTimer() {
        timer.start();
    }
}
