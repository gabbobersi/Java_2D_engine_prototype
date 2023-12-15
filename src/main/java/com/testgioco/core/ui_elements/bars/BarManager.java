package com.testgioco.core.ui_elements.bars;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;

/**
 * Da inserire nelle classi apposite
 */
public class BarManager  {
    private int width = GameSettings.screenWidth - 100;
    private int height = 15;
    private int staminaLabelHeight = 130;
    private int healthLabelHeight = 50;

    private Health healthBar;
    private Stamina staminaBar;

    public BarManager(Vector2DInt position){
        healthBar = new Health(new Vector2DInt(position.getX(), position.getY()), width, height, "Health");
        staminaBar = new Stamina(new Vector2DInt(position.getX(), position.getY() +20), width, height, "Stamina");
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
