package com;

import com.gameStart.StartGame;
import com.view.panels.WarningPanel;

import javax.swing.*;

public class AppPandemiaSimulator {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        WarningPanel warningPanel = new WarningPanel();

        try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
             warningPanel.warn('f', "Tema não suportado: sua versão do Java está atualizada?");
        }

        StartGame game = new StartGame();
        game.run();

    }
}
