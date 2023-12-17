package com.testgioco.core.particles;

import com.testgioco.utilities.GameSettings;

import java.awt.*;
import java.util.Random;

public class SnowParticle {
    private int x;
    private int y;
    private final int size;

    public SnowParticle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void move() {
        y += 1; // Speed
        if (y > GameSettings.screenHeight) {
            y = 0;
            x = new Random().nextInt(GameSettings.screenWidth);
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }
}