package game;

import game.gameBuilder.Builder;
import game.gameBuilder.IBuilder;
import game.gameBuilder.Level;
import game.gameBuilder.RepeatedComponentsException;
import game.gameControl.Game;
import game.gameControl.IGameApp;
import game.view.StartGamePanel;
import game.view.WarningPanel;

import java.io.IOException;

public class StartGame implements ILevel {
    String directory;

    public StartGame(){

    }

    public void run(String directory){
        this.directory = directory;
        StartGamePanel gamePanel = new StartGamePanel();
        gamePanel.connect(this);
        gamePanel.visual(directory);
    }


    public void chooseLevel(int level) {
        IBuilder builder = new Builder();
        IGameApp game = new Game();
        builder.connect(game);
        WarningPanel warningPanel = new WarningPanel();

        Level[] levels;
        try {
            levels = builder.createLevels(directory);
            builder.buildGame(directory, levels[level]);
            game.runGame();
        } catch(IOException e) {
            warningPanel.warn('e', "Diretório das fases não encontrado: CSV não lido");
        } catch(RepeatedComponentsException e){
            warningPanel.warn('e', "Mais de uma componente na mesma posição do CSV: seu csv está correto?");
        }
    }

}
