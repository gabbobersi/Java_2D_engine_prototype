package com.testgioco.core;

import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Test1;
import com.testgioco.core.ui_elements.Window;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.Singletons;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;

public class Game implements Runnable {
    private final Constants constants = new Constants();
    private Thread gameThread;
    private JPanel activePanel;
    private GameState gameState;

    public enum GameState {
        MAIN_MENU,
        TEST_1,
        TILE_MAP_GENERATOR
    }


    public void changeGameState(GameState newState) {
        gameState = newState;
        switch (newState) {
            case MAIN_MENU:
                activePanel = new MainMenu();
                break;
            case TEST_1:
                activePanel = new Test1();
                break;
            case TILE_MAP_GENERATOR:
                activePanel = new TileMapGenerator();
                break;
        }
    }

    public Game() {
        // Default panel
        activePanel = new MainMenu();
        Window window = new Window(activePanel);
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
            activePanel.repaint();
        }
    }

    private void processInput(){
        Singletons.player.getInput();
    }

    private void updateGame(){
        Singletons.player.update();
    }
}
