package com.testgioco.core;

import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Play;
import com.testgioco.core.scenes.Test;
import com.testgioco.utilities.Constants;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable {
    private final Constants constants = new Constants();
    private Thread gameThread;
    private volatile boolean isRunning = true;
    private Window window;

    private MainMenu mainMenu;
    private Play play;
    private TileMapGenerator tmapgen;
    private Test test;

    public Game() {
        // Is this necessary? Should I create an instance on demand only?
        mainMenu = new MainMenu();
        play = new Play();
        tmapgen = new TileMapGenerator();
        test = new Test();

        // Default panel
        window = new Window();
        window.setPanel(getPanelInstance(GameState.getActiveState()));
    }

    public void start(){
        SwingUtilities.invokeLater(() -> {
            gameThread = new Thread(this);
            gameThread.start(); // Calls "run" method, in a new thread.
        });
    }

    /**
     * Game loop
     * */
    @Override
    public void run() {
        double previous = System.nanoTime();
        double lag = 0.0;

        while (isRunning){
            GameState.State activeState = GameState.getActiveState();
            boolean setPanel = false;
            double current = System.nanoTime();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;

            processInput(activeState);

            // In this while, FPS limit execution.
            while (lag >= constants.NS_PER_UPDATE){
                updateGame(activeState);
                lag -= constants.NS_PER_UPDATE;
                if (GameState.getPreviousState() != GameState.getActiveState()){
                    System.out.println("Cambio scena: da " + GameState.getPreviousState() + " a " + GameState.getActiveState());
                    setPanel = true;
                }
                runScene(activeState, setPanel);
                drawScene(activeState);
            }
        }
    }

    private void runScene(GameState.State state, boolean setPanel){
        if (setPanel){
            window.setPanel(getPanelInstance(state));
        }
        GameState.setActiveState(state);

        switch (state){
            case MAIN_MENU:
                mainMenu.run();
                break;
            case PLAY:
                play.run();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.run();
                break;
            case QUIT:
                stop();
                window.dispose();
                System.exit(0);
                break;
            case TEST:
                test.run();
                break;
            default:
                System.out.println("WARNING - Eseguo il run di mainMenu perché non ho trovato lo stato che ti " +
                        "interessa!");
                mainMenu.run();
        }
    }

    /**
     * Return the instance corresponding to the specified state.
     * */
    private JPanel getPanelInstance(GameState.State state) {
        switch (state) {
            case MAIN_MENU:
                return mainMenu;
            case PLAY:
                return play;
            case TILE_MAP_GENERATOR:
                return tmapgen;
            case TEST:
                return test;
            default:
                System.out.println("WARNING - getPanelInstance - Non ho trovato lo stato di cui vuoi l'istanza!");
                return mainMenu;
        }
    }

    private void drawScene(GameState.State state){
        switch (state){
            case MAIN_MENU:
                mainMenu.repaint();
                break;
            case PLAY:
                play.repaint();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.repaint();
                break;
            case TEST:
                test.repaint();
                break;
            default:
                System.out.println("WARNING - drawScene - Non ho trovato lo stato che vorresti disegnare!");
                mainMenu.repaint();
        }
    }

    private void processInput(GameState.State state){
        if (state == GameState.State.PLAY){
            play.processInput();
        }
    }

    private void updateGame(GameState.State state){
        if (state == GameState.State.PLAY){
            play.updateGame();
        }
    }

    private void stop(){
        isRunning = false;
    }
}
