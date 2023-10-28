package com.testgioco.core.ui_elements;

import com.testgioco.utilities.GameSettings;

import javax.swing.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(Panel gamePanel){
        setTitle(settings.gameTitle);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        pack();
        setSize(settings.screenWidth, settings.screenHeight);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
