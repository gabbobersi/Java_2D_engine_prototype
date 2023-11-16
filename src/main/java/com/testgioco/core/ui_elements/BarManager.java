package com.testgioco.core.ui_elements;

import javax.swing.*;

// Attributi di classe
public class BarManager extends JFrame {
    /**
     * Classe che implementa le barre della vita e della stamina, in futuro si vedrà
     * se tenerle qui o fare delle barre separate
     */

    private JProgressBar healthBar;
    private JProgressBar staminaBar;

    // Costruttori
    public BarManager(){
        setTitle("Health");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("Stamina");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creazione barre
        healthBar = new JProgressBar(0,100);
        healthBar.setValue(100);
        healthBar.setStringPainted(true);

        staminaBar = new JProgressBar(0, 100);
        staminaBar.setValue(100);
        staminaBar.setStringPainted(true);
    }
}
