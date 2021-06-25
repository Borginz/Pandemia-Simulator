package game.view;

import game.gameControl.IPauseTimer;
import game.view.institutionview.IRPauseTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WarningPanel extends JFrame implements IWarningPanel, IRPauseTimer, WindowListener {
    JLabel title;
    JLabel description;
    IPauseTimer timerControl;

    private static final long serialVersionUID = 5648764998222329459L;

    public WarningPanel(){
        super();
        addWindowListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        setSize(400,150);
        setResizable(false);
        setLocationRelativeTo(null);
        visual();
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 1, 15, 15));

        title = new JLabel();
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(20.0f));
        description = new JLabel();
        description.setHorizontalAlignment(JLabel.CENTER);

        principalPanel.add(title);
        principalPanel.add(description);
    }

    public void warn(char state, String message) {
        if(state == 'w'){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            title.setText("Você ganhou!");
        } else if(state == 'l'){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            title.setText("Você perdeu!");
        } else if(state == 'e'){
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            title.setText("Erro!");
        }

        description.setText(message);
        timerControl.pauseTimer();
        setVisible(true);
    }

    public void connect(IPauseTimer timerControl) {
        this.timerControl = timerControl;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        setVisible(false);
        timerControl.resumeTimer();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
