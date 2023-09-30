package com.testgioco.ui_elements;

import javax.swing.*;

public class Window {
    final JFrame window;
    public Window(Panel gamePanel){
        this.window = new JFrame();
        this.window.add(gamePanel);
        this.window.pack();
        this.window.setSize(620, 480);

        this.window.setLocationRelativeTo(null);
        this.window.setTitle("Gioco di esempio");
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);

        gamePanel.start();
    }
}
