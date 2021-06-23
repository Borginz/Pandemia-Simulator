package game.gameControl;

import game.city.City;
import game.view.View;

import javax.swing.*;

public class Game implements IGame{
    Timer timer;
    Keyboard keyboard;
    City city;
    View view;

    public Game(){

    }

    public void connectComponents(City city, View view) {
        this.city = city;
        this.view = view;
    }

    public void runGame(){
        timer = new Timer(1000, city);
        keyboard = new Keyboard(view);
        view.addKeyListener(keyboard);
        resumeTimer();

        view.createView();
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
