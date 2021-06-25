
import game.StartGame;
import game.view.WarningPanel;

import javax.swing.*;
import java.net.URISyntaxException;


public class AppPandemiaSimulator {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String directory = "";
        WarningPanel warningPanel = new WarningPanel();
        try {
            directory = AppPandemiaSimulator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "/";
        } catch (URISyntaxException e) {
            warningPanel.warn('e', "Erro na sintaxe do caminho do arquivo: talvez o caminho tenha caracteres não suportados.");
        } catch (NullPointerException e){
            warningPanel.warn('e', "Erro na sintaxe do caminho do arquivo: talvez o programa esteja corrompido ou o caminho não seja suportado.");
        }


        try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
             warningPanel.warn('e', "Tema não suportado: sua versão do Java está atualizada?");
        }

        StartGame game = new StartGame();
        game.run(directory);

    }
}
