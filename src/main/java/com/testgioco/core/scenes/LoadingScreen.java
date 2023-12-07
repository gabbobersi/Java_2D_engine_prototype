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

    public LoadingScreen(){
        super();
        loadingLabel = new Label(new Vector2DInt(GameSettings.screenWidth / 2 - 100,
                GameSettings.screenHeight / 2 - 50),
                "Loading...", new Font("Comic Sans", Font.PLAIN, 25), Color.WHITE);
    }
    @Override
    public void awake() {
        setBackground(Color.BLACK);
        Timer loadingTimer = new Timer(3000, e -> {
            GameState.setActiveState(GameState.State.MAIN_MENU);
        });
        loadingTimer.setRepeats(false);
        loadingTimer.start();
    }

    @Override
    public void update() {
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
        Graphics2D g2 = (Graphics2D)g;
        loadingLabel.draw(g2);
        g2.dispose();
    }
}
