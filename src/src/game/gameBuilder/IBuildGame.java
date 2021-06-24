package game.gameBuilder;

public interface IBuildGame {
    Level[] createLevels(String directory);
    void buildGame(String directory, Level level);
}
