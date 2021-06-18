package game.gameControl;

import game.city.City;
import game.mayor.Mayor;
import game.view.View;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Game implements IGame{
    Timer timer;
    Keyboard keyboard;
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

        view.createView();

        keyboard = new Keyboard(mayor);
        resumeTimer();
    }

    public void pauseTimer() {
        timer.stop();
        keyboard.stop();
    }

    public void resumeTimer() {
        timer.start();
        keyboard.start();
    }
}
