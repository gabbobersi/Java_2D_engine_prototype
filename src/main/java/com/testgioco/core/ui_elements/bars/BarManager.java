package com.testgioco.core.ui_elements.bars;
import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

/**
 * Da inserire nelle classi apposite
 */
public class BarManager  {
    private int width = 400;
    private int height = 30;

    private Health healthBar;
    private Stamina staminaBar;

    public BarManager(){
        healthBar = new Health(new Vector2DInt(100, GameSettings.screenHeight - 100), width, height);
        staminaBar = new Stamina(new Vector2DInt(100, GameSettings.screenHeight - 50), width, height);
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
