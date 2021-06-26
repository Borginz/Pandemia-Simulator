package com.view.panels;

import com.gameStart.ILevel;
import com.view.icons.TitleIcon;

import javax.swing.*;
import java.awt.*;

public class StartGamePanel extends JFrame {

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

        TitleIcon title = new TitleIcon();
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton easy = new JButton("Fácil");
        easy.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        easy.setFont(new Font("Corbel", Font.PLAIN, 25));
        easy.addActionListener(e -> {
            levelChoose.chooseLevel(0);
            dispose();
        });

        JButton medium = new JButton("Médio");
        medium.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        medium.setFont(new Font("Corbel", Font.PLAIN, 25));
        medium.addActionListener(e -> {
            levelChoose.chooseLevel(1);
            dispose();
        });

        JButton hard = new JButton("Difícil");
        hard.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        hard.setFont(new Font("Corbel", Font.PLAIN, 25));
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

