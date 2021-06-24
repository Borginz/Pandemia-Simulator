package game.gameBuilder;

public class Level {
    char[][] matrix;
    int population;
    int sizeX;
    int sizeY;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public int getPopulation() {
        return population;
    }

    int level;

    public Level(int level, char[][] matrix, int population, int sizeX, int sizeY){
        this.matrix = matrix;
        this.level = level;
        this.population = population;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
