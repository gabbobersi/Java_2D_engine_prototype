package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

import javax.swing.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(JPanel activePanel){
        setTitle(settings.gameTitle);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(activePanel);
        pack();
        setSize(settings.screenWidth, settings.screenHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
    }

    public void setPanel(JPanel panel) {
        SwingUtilities.invokeLater(() -> {
            this.getContentPane().removeAll();
            this.add(panel);
            this.revalidate();
            this.repaint();
        });
    }
}
