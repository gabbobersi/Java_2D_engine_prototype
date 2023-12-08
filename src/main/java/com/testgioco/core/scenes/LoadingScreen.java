package com.testgioco.core.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Label;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JPanel implements Scene {
    private Label loadingLabel;
    private float r;
    private float g;
    private float b;

    public LoadingScreen() {
        super();
        loadingLabel = new Label(new Vector2DInt(GameSettings.screenWidth / 2 - 100, GameSettings.screenHeight / 2 - 50), "Loading...", new Font("Comic Sans", Font.PLAIN, 25), Color.WHITE);
    }

    @Override
    public void awake() {
        r = 1.0f;
        g = 1.0f;
        b = 1.0f;

        Timer loadingTimer = new Timer(3000, e -> {
            GameState.setActiveState(GameState.State.MAIN_MENU);
        });
        loadingTimer.setRepeats(false);
        loadingTimer.start();
    }

    @Override
    public void update() {
        fadeOutFX();
    }

    @Override
    public void fixedUpdate() {
    }

    @Override
    public void unload(int delay) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        loadingLabel.draw(g2);
        g2.dispose();
    }

    private void fadeOutFX() {
        r = Math.max(r - 0.01f, 0);
        g = Math.max(g - 0.01f, 0);
        b = Math.max(b - 0.01f, 0);
        setBackground(new Color(r, g, b));
    }
}