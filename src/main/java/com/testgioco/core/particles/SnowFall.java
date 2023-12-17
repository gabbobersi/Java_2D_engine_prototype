package com.testgioco.core.particles;

import com.testgioco.core.interfaces.ui.VisibleUI;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Vector2DInt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SnowFall implements VisibleUI {
    private ArrayList<SnowParticle> snowflakes;
    private boolean isVisible = true;

    public SnowFall() {
        snowflakes = new ArrayList<>();

        // Crea alcune particelle di neve iniziali
        for (int i = 0; i < 100; i++) {
            snowflakes.add(new SnowParticle(new Random().nextInt(GameSettings.screenWidth),
                    new Random().nextInt(GameSettings.screenHeight),
                    3));
        }

        Timer timer = new Timer(20, e -> {
            // Aggiorna la posizione di tutte le particelle della neve
            for (SnowParticle snowflake : snowflakes) {
                snowflake.move();
            }
        });
        timer.start();
    }

    @Override
    public void draw(Graphics2D g2) {
        if (!isVisible)
            return;

        // Disegna tutte le particelle della neve
        for (SnowParticle snowflake : snowflakes) {
            snowflake.draw(g2);
        }
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public Vector2DInt getPositionOnTheScreen() {
        return null;
    }
}