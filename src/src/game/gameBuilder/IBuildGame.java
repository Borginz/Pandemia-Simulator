package game.gameBuilder;

import java.io.IOException;

public interface IBuildGame {
    Level[] createLevels(String directory) throws IOException, RepeatedComponentsException;
    void buildGame(String directory, Level level);
}
