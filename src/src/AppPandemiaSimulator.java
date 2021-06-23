import game.gameBuilder.Builder;
import game.gameBuilder.IBuilder;

import game.gameControl.*;

public class AppPandemiaSimulator {

    public static void main(String[] args) {
        //String directory = AppPandemiaSimulator.class.getResource(".").getPath(); // TODO: TREAT NULLPOINTER
        String directory = "/C:/";
        IBuilder builder = new Builder();
        IGameApp game = new Game();
        builder.connect(game);
        builder.buildGame(directory);
        game.runGame();
    }
}
