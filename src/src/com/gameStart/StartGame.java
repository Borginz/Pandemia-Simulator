package com.gameStart;

import com.exceptions.InvalidPositionException;
import com.gameBuilder.Builder;
import com.gameBuilder.IBuilder;
import com.gameBuilder.Level;
import com.exceptions.RepeatedComponentsException;
import com.gameControl.Game;
import com.gameControl.IGameApp;
import com.gameStart.ILevel;
import com.view.panels.StartGamePanel;
import com.view.panels.WarningPanel;

import java.io.IOException;

public class StartGame implements ILevel {
    WarningPanel warningPanel;

    public StartGame(){
        warningPanel = new WarningPanel();
    }

    public void run(){
        try {
            StartGamePanel gamePanel = new StartGamePanel();
            gamePanel.connect(this);
            gamePanel.visual();
        } catch (NullPointerException e) {
            warningPanel.warn('e', "Imagem do título não encontrada: talvez seu arquivo .JAR esteja corrompido!");
        }
    }


    public void chooseLevel(int level) {
        IBuilder builder = new Builder();
        IGameApp game = new Game();
        builder.connect(game);

        Level[] levels;
        try {
            levels = builder.createLevels();
            builder.buildGame(levels[level]);
            game.runGame();
        } catch(IOException|NullPointerException e) {
            warningPanel.warn('f', "Arquivo essencial ao programa não lido corretamente.");
        } catch(RepeatedComponentsException e){
            warningPanel.warn('f', "Mais de uma componente na mesma posição do CSV: seu csv está correto?");
        } catch(InvalidPositionException e){
            warningPanel.warn('f', "Posição inválida: seu CSV não contém algo fora dos limites do tamanho do tabuleiro?");
        }
    }

}
