package com.testgioco.core;

import com.testgioco.core.ui_elements.Label;
import com.testgioco.core.ui_elements.Panel;
import com.testgioco.core.ui_elements.Window;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

import java.awt.*;

public class Game implements Runnable {
    private final GameSettings settings = new GameSettings();
    private final Constants constants = new Constants();
    private Thread gameThread;

    private final Panel panel;

    public Game() {
        InputHandler keyH = new InputHandler();
        panel = new Panel(keyH, Color.BLACK);
        Window window = new Window(panel);
    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start(); // Calls "run" method, in a new thread.
    }
    @Override
    public void run() {
        double previous = System.nanoTime();
        double lag = 0.0;

        while (gameThread != null){
            double current = System.nanoTime();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;

            processInput();

            while (lag >= constants.NS_PER_UPDATE){
                updateGame();
                lag -= constants.NS_PER_UPDATE;
            }
            panel.repaint();
        }
    }

    private void processInput(){
        panel.player.getInput();
    }

    private void updateGame(){
        panel.player.update();
    }
}
