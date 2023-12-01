package com.testgioco.core.ui_elements.bars;
import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

/**
 * Da inserire nelle classi apposite
 */
public class BarManager  {
    private GameSettings settings = new GameSettings();
    private int width = 400;
    private int height = 30;
    private int staminaLabelHeight = 130;
    private int healthLabelHeight = 50;

    private Health healthBar;
    private Stamina staminaBar;
    private JLabel healthLabel;
    private JLabel staminaLabel;

    public BarManager(){
        healthBar = new Health(new Vector2DInt(10, 10), width, height);
        staminaBar = new Stamina(new Vector2DInt(10, 50), width, height);

        healthLabel = new JLabel("Health:");
        healthLabel.setBounds(80, 50, 100, healthLabelHeight);
        staminaLabel = new JLabel("Stamina:");
        staminaLabel.setBounds(10, 50, 60, staminaLabelHeight);
    }

    public void reduceHealth(int value){
        healthBar.reduce(value);
    }

    public void reduceStamina(int value){
        staminaBar.reduce(value);
    }

    public void resetHealth(){
        healthBar.reset();
    }

    public void resetStamina(){
        staminaBar.reset();
    }

    public void draw(Graphics2D g2){
        healthBar.draw(g2);
        staminaBar.draw(g2);
        healthLabel.paint(g2);
        staminaLabel.paint(g2);
    }

}
