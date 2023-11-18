package com.testgioco.core;

import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Play;
import com.testgioco.utilities.Constants;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;

public class Game implements Runnable {
    private final Constants constants = new Constants();
    private Thread gameThread;
    private volatile boolean isRunning = true;
    private Window window;

    private MainMenu mainMenu;
    private Play play;
    private TileMapGenerator tmapgen;

    public Game() {
        // Is this necessary? Should I create an instance on demand only?
        mainMenu = new MainMenu();
        play = new Play();
        tmapgen = new TileMapGenerator();

        // Default panel
        window = new Window();
        window.setPanel(mainMenu);
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

            while (lag >= constants.NS_PER_UPDATE){
                updateGame(activeState);
                lag -= constants.NS_PER_UPDATE;
            }

            if (GameState.getPreviousState() != GameState.getActiveState()){
                System.out.println("Cambio scena: da " + GameState.getPreviousState() + " a " + GameState.getActiveState());
                setPanel = true;
            }
            runScene(activeState, setPanel);
            drawScene(activeState);


        }
    }

    private void runScene(GameState.State state, boolean setPanel){
        if (setPanel){
            window.setPanel(getPanelForState(state));
        }
        GameState.setActiveState(state);

        switch (state){
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
            default:
                mainMenu.run();
        }
    }

    private JPanel getPanelForState(GameState.State state) {
        switch (state) {
            case PLAY:
                return play;
            case TILE_MAP_GENERATOR:
                return tmapgen;
            default:
                return mainMenu;
        }
    }

    private void drawScene(GameState.State state){
        switch (state){
            case PLAY:
                play.repaint();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.repaint();
                break;
            default:
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
