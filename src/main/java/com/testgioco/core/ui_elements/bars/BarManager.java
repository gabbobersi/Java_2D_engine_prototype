package com.testgioco.core.ui_elements.bars;
import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

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

    public BarManager(Vector2DInt barsPosition){
        healthBar = new Health(new Vector2DInt(barsPosition.getX(), barsPosition.getY()), width, height, "Health");
        staminaBar = new Stamina(new Vector2DInt(barsPosition.getX(), barsPosition.getY() +40), width, height, "Stamina");
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
    }

}
