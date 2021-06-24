
import game.StartGame;


public class AppPandemiaSimulator {

    public static void main(String[] args) {
        //String directory = AppPandemiaSimulator.class.getResource(".").getPath(); // TODO: TREAT NULLPOINTER
        String directory = "/C:/";

        StartGame game = new StartGame();
        game.run(directory);

    }
}
