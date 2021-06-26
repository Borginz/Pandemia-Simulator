package com.gameControl;

import com.view.IKeyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    IKeyboard listener;
    Boolean started;

    public Keyboard(IKeyboard listener) {
        this.listener = listener;
        started = false;
    }

    public void stop(){
        started = false;
    }

    public void start(){
        started = true;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(started)
            listener.keyPress(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }


}
