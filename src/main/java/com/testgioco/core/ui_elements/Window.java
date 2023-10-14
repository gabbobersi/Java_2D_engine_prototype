package com.testgioco.core.ui_elements;

import com.testgioco.utilities.GameSettings;

import javax.swing.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(Panel gamePanel){
        this.setTitle(settings.gameTitle);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(gamePanel);
        this.pack();

        this.setSize(settings.screenWidth, settings.screenHeight);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.start();
    }
}
