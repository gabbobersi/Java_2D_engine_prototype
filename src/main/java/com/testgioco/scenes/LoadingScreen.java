package com.testgioco.scenes;

import com.testgioco.core.GameState;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Label;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JPanel implements Scene {
    private final Label loadingLabel;
    private float r;
    private float g;
    private float b;
    private GameState.State previousState;

    public LoadingScreen() {
        super();
        loadingLabel = new Label(new Vector2DInt(GameSettings.screenWidth / 2 - 100, GameSettings.screenHeight / 2 - 50), "Loading...", new Font("Comic Sans", Font.PLAIN, 25), Color.WHITE);
    }

    @Override
    public void awake() {
        previousState = GameState.getPreviousState();

//        System.out.println("Stato precedente: " + previousState);

        if (previousState == GameState.State.MAIN_MENU){
            setBackground(Color.BLACK);
            r = 0.0f;
            g = 0.0f;
            b = 0.0f;
        }
        else if (previousState == GameState.State.PLAY) {
            setBackground(Color.WHITE);
            r = 1.0f;
            g = 1.0f;
            b = 1.0f;
        }


        Timer loadingTimer = new Timer(3000, e -> {
            // Specify the scene to load when the timer ends, based on the current active scene.
            System.out.println("ESEGUO AZIONE DENTRO A TIMER");
            if (previousState == GameState.State.PLAY)
                GameState.setNextState(GameState.State.MAIN_MENU);
            else if (previousState == GameState.State.MAIN_MENU)
                GameState.setNextState(GameState.State.PLAY);
        });
        loadingTimer.setRepeats(false);
        loadingTimer.start();
    }

    @Override
    public void update() {
        if (previousState == GameState.State.MAIN_MENU)
            fadeInFX();
        else if (previousState == GameState.State.PLAY)
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

    private void fadeInFX() {
        r = Math.min(r + 0.01f, 1);
        g = Math.min(g + 0.01f, 1);
        b = Math.min(b + 0.01f, 1);
        setBackground(new Color(r, g, b));
    }

    private void fadeOutFX() {
        r = Math.max(r - 0.01f, 0);
        g = Math.max(g - 0.01f, 0);
        b = Math.max(b - 0.01f, 0);
        setBackground(new Color(r, g, b));
    }
}