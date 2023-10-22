package com.testgioco.core;

import com.testgioco.core.ui_elements.Panel;
import com.testgioco.core.ui_elements.Window;
import com.testgioco.entities.Player;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

import java.awt.*;

public class Game implements Runnable {
    private final GameSettings settings = new GameSettings();
    private final Constants constants = new Constants();

    private final Fps fps = new Fps();
    private final InputHandler keyH = new InputHandler();
    private Thread gameThread;

    private final Panel panel;
    private final Window window;

    public Game() {
        panel = new Panel(keyH, Color.BLACK);
        window = new Window(panel);
    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start(); // Calls "run" method, in a new thread.
    }
    @Override
    public void run() {
        while (gameThread != null) {
            update();
            if (fps.canDrawAccumulator(true)){
                // Calls its "paintComponent" method
                panel.repaint();
            }
        }
    }

    public void update(){
        panel.player.update(fps.deltaTime);
    }
}
