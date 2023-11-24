package com.testgioco.core;

import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(JPanel mainPanel){
        setTitle(settings.gameTitle);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(settings.screenWidth, settings.screenHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        add(mainPanel);
        pack();
    }
}
