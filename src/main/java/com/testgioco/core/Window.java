package com.testgioco.core;

import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    GameSettings settings = new GameSettings();
    public Window(){
        setTitle(settings.gameTitle);
    }

    public void setPanel(JPanel panel) {
        // Prevents that mouse pressed event propagate through panels
        Singletons.mouseH.released = true;
        Singletons.mouseH.x = 0;
        Singletons.mouseH.y = 0;

        SwingUtilities.invokeLater(() -> {
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(settings.screenWidth, settings.screenHeight);
            getContentPane().removeAll();
            add(panel);

            // Panel settings
            panel.setBackground(Color.WHITE);
            panel.setFocusable(true);
            panel.requestFocus();
            panel.setDoubleBuffered(true);
            panel.setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));

            pack();
            revalidate();
            repaint();
            setLocationRelativeTo(null);
            setVisible(true);
            setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        });
    }
}
