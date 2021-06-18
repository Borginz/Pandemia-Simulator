package game.gameControl;

import game.mayor.IKeyboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
            listener.keyPress(ke.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }


}
