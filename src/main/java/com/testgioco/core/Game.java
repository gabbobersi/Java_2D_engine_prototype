package com.testgioco.core;

import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Test1;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.Singletons;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;

public class Game implements Runnable {
    private final Constants constants = new Constants();
    private Thread gameThread;
    private Window window;

    private MainMenu mainMenu;
    private Test1 test1;
    private TileMapGenerator tmapgen;

    public Game() {
        // Is this necessary? Should I create an instance on demand only?
        mainMenu = new MainMenu();
        test1 = new Test1();
        tmapgen = new TileMapGenerator();

        // Default panel
        window = new Window(mainMenu);
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

            GameState.State activeState = GameState.getActiveState();
            runScene(activeState);
            drawScene(activeState);

        }
    }

    private void runScene(GameState.State state){
        window.getContentPane().removeAll();
        GameState.setActiveState(state);

        switch (state){
            case TEST_1:
                window.add(test1);
                test1.run();
                break;
            case TILE_MAP_GENERATOR:
                window.add(tmapgen);
                tmapgen.run();
                break;
            case QUIT:
                window.dispose();
                System.exit(0);
            default:
                window.add(mainMenu);
                mainMenu.run();
        }

        if (GameState.getPreviousState() != GameState.getActiveState()){
            // Make changes to panel, visible
            System.out.println("Rivalido! Vecchio: " + GameState.getPreviousState() + " Nuovo: " + GameState.getActiveState());
            window.revalidate();
            window.repaint();
        }
    }

    private void drawScene(GameState.State state){
        switch (state){
            case TEST_1:
                test1.repaint();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.repaint();
                break;
            default:
                mainMenu.repaint();
        }
    }

    private void processInput(){
        Singletons.player.getInput();
    }

    private void updateGame(){
        Singletons.player.update();
    }
}
