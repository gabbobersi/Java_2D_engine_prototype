package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(JPanel mainPanel){
        setTitle(GameSettings.gameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(new Dimension(GameSettings.screenWidth, GameSettings.screenHeight));
        add(mainPanel);

        pack();

        setVisible(true);
        setLocationRelativeTo(null);
        setFocusable(true);
        setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        setResizable(false);
        setLayout(null);
    }
}
