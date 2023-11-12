package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(){
        setTitle(settings.gameTitle);
    }

    public void setPanel(JPanel panel) {
        SwingUtilities.invokeLater(() -> {
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(settings.screenWidth, settings.screenHeight);
            getContentPane().removeAll();
            add(panel);
            panel.setBackground(Color.WHITE);
            panel.requestFocus();
            pack();
            revalidate();
            repaint();
            setLocationRelativeTo(null);
            setVisible(true);
            setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        });
    }
}
