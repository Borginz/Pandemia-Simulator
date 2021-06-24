package game.view;

import game.ILevel;
import game.gameControl.IPauseTimer;
import game.view.institutionview.IRPauseTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serial;

public class StartGamePanel extends JFrame {

    @Serial
    private static final long serialVersionUID = -522296158933416939L;

    private ILevel levelChoose;

    public StartGamePanel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400,600);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void visual(){
        JPanel principalPanel = new JPanel();
        getContentPane().add(principalPanel);
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        principalPanel.setLayout(new GridLayout(0, 1, 15, 15));

        JLabel title = new JLabel("Pandemia Simulator");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(20.0f));

        JButton easy = new JButton("Fácil");
        easy.addActionListener(e -> {
            levelChoose.chooseLevel(0);
            dispose();
        });

        JButton medium = new JButton("Médio");
        medium.addActionListener(e -> {
            levelChoose.chooseLevel(1);
            dispose();
        });

        JButton hard = new JButton("Difícil");
        hard.addActionListener(e -> {
            levelChoose.chooseLevel(2);
            dispose();
        });

        principalPanel.add(title);
        principalPanel.add(easy);
        principalPanel.add(medium);
        principalPanel.add(hard);
        setVisible(true);
    }

    public void connect(ILevel levelChoose) {
        this.levelChoose = levelChoose;
    }
}

