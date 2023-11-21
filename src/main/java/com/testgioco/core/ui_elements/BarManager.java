package com.testgioco.core.ui_elements;
import javax.swing.*;
import java.awt.*;


/**
 * Da inserire nelle classi apposite
 */
public class BarManager extends JFrame {
    private JProgressBar healthBar;
    private JProgressBar staminaBar;

    public BarManager() {
        // Impostazioni della finestra
        setTitle("Health and Stamina Bar");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creazione delle barre
        healthBar = new JProgressBar(0, 100);
        healthBar.setValue(100);
        healthBar.setStringPainted(true);

        staminaBar = new JProgressBar(0, 100);
        staminaBar.setValue(100);
        staminaBar.setStringPainted(true);

        // Pannello per contenere le barre (Da inserire nella classe apposita)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(healthBar);
        panel.add(staminaBar);

        // Aggiunta del pannello alla finestra
        add(panel);
    }

    // Metodi

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarManager bar = new BarManager();
            bar.setVisible(true);
        });
    }
}
