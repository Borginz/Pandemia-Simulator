
import game.StartGame;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.text.ParseException;
import java.util.Objects;


public class AppPandemiaSimulator {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //String directory = Objects.requireNonNull(AppPandemiaSimulator.class.getResource(".")).getPath(); // TODO: TREAT NULLPOINTER
        String directory = "/C:/";

        try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }

        StartGame game = new StartGame();
        game.run(directory);

    }
}
