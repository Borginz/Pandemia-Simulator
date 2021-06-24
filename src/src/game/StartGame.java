package game;

import game.gameBuilder.Builder;
import game.gameBuilder.IBuilder;
import game.gameBuilder.Level;
import game.gameControl.Game;
import game.gameControl.IGameApp;
import game.view.StartGamePanel;

public class StartGame implements ILevel {
    String directory;

    public StartGame(){

    }

    public void run(String directory){
        this.directory = directory;
        StartGamePanel gamePanel = new StartGamePanel();
        gamePanel.connect(this);
        gamePanel.visual();
    }


    public void chooseLevel(int level){
        IBuilder builder = new Builder();
        IGameApp game = new Game();
        builder.connect(game);

        Level[] levels = builder.createLevels(directory);

        builder.buildGame(directory, levels[level]);
        game.runGame();
    }

}
