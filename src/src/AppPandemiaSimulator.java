import game.gameBuilder.Builder;
import game.gameBuilder.IBuilder;

import game.gameControl.*;

public class AppPandemiaSimulator {

    public static void main(String[] args) {
        IBuilder builder = new Builder();
        IGame game = new Game();
        builder.connect(game);
        builder.buildGame();
        game.runGame();
    }
}
