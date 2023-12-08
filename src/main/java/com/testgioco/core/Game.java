package com.testgioco.core;

import com.testgioco.core.scenes.LoadingScreen;
import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Play;
import com.testgioco.core.scenes.Test;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Handlers;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable {
    private Thread gameThread;
    private volatile boolean isRunning = true;

    private final Window window;
    private static final JPanel mainPanel = new JPanel();
    private final CardLayout cardLayout;

    private final MainMenu mainMenu;
    private final Play play;
    private final TileMapGenerator tmapgen;
    private final Test test;
    private final LoadingScreen loadingScreen;

    public Game() {
        mainMenu = new MainMenu();
        play = new Play();
        tmapgen = new TileMapGenerator();
        test = new Test();
        loadingScreen = new LoadingScreen();

        // Setting the cardLayout system
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.setBounds(0, 0, GameSettings.screenWidth, GameSettings.screenHeight);
        mainPanel.setPreferredSize(new Dimension(GameSettings.screenWidth, GameSettings.screenHeight));

        // Adding all the "cards" to the main panel
        mainPanel.add(mainMenu, GameState.State.MAIN_MENU.name());
        mainPanel.add(play, GameState.State.PLAY.name());
        mainPanel.add(tmapgen, GameState.State.TILE_MAP_GENERATOR.name());
        mainPanel.add(test, GameState.State.TEST.name());
        mainPanel.add(loadingScreen, GameState.State.LOADING_SCREEN.name());

        // Show the default card
        window = new Window(mainPanel);
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
        Fps fps = new Fps();
        double previous = System.nanoTime();
        double lag = 0.0;
        double fixedUpdateTimer = 0;

        changeScene(GameState.getActiveState());
        while (isRunning){
            GameState.State activeState = GameState.getActiveState();
            GameState.State nextState = GameState.getNextState();

            double current = System.nanoTime();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;

            if (nextState != GameState.State.EMPTY){
                System.out.println("Cambio scena: da " + activeState + " a " + nextState);
                // Changing scene actions.
                unloadScene(activeState, 80);
                changeScene(nextState);
                awakeScene(nextState);
            }

            // In this while, FPS limit execution.
            while (lag >= Constants.NANOSECONDS_PER_UPDATE){
                lag -= Constants.NANOSECONDS_PER_UPDATE;
                updateScene(activeState);
                fps.increment();
            }

            drawScene(activeState);

            // When 0.2 (constants) seconds is passed, execute the fixedUpdate of the scene.
            fixedUpdateTimer += elapsed;
            if (fixedUpdateTimer >= Constants.NANOSECONDS_PER_FIXED_UPDATE){
                fixedUpdateTimer = 0;
                fixedUpdateScene(activeState);
            }

            fps.print(elapsed);
        }
    }

    private void fixedUpdateScene(GameState.State state){
        switch (state){
            case MAIN_MENU:
                mainMenu.fixedUpdate();
                break;
            case PLAY:
                play.update();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.fixedUpdate();
                break;
            case TEST:
                test.fixedUpdate();
                break;
            case LOADING_SCREEN:
                loadingScreen.fixedUpdate();
                break;
            default:
                System.out.println("WARNING - Eseguo il fixedUpdate di mainMenu perché non ho trovato lo stato che ti" +
                        " interessa!");
                mainMenu.fixedUpdate();
        }
    }

    private void changeScene(GameState.State nextState){
        GameState.setActiveState(nextState);
        setupPanel(nextState);
        Handlers.mouseH.reset();
        setupScene(nextState);
    }

    private void awakeScene(GameState.State nextState){
        switch (nextState){
            case MAIN_MENU:
                mainMenu.awake();
                break;
            case PLAY:
                play.awake();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.awake();
                break;
            case TEST:
                test.awake();
                break;
            case LOADING_SCREEN:
                loadingScreen.awake();
                break;
            default:
                if (!nextState.name().equals(GameState.State.QUIT.name())) {
                    System.out.println("WARNING - Awake - Can't find scene");
                }
                mainMenu.awake();
        }
    }

    private void unloadScene(GameState.State state, int delay){
        switch (state){
            case MAIN_MENU:
                mainMenu.unload(delay);
                break;
            case PLAY:
                play.unload(delay);
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.unload(delay);
                break;
            case TEST:
                test.unload(delay);
                break;
            case LOADING_SCREEN:
                loadingScreen.unload(delay);
                break;
            default:
                if (!state.name().equals(GameState.State.QUIT.name())) {
                    System.out.println("WARNING - Unload - Can't find scene");
                }
        }
    }

    private void updateScene(GameState.State state){
        switch (state){
            case MAIN_MENU:
                mainMenu.update();
                break;
            case PLAY:
                play.update();
                break;
            case TILE_MAP_GENERATOR:
                tmapgen.update();
                break;
            case QUIT:
                stop();
                window.dispose();
                System.exit(0);
                break;
            case TEST:
                test.update();
                break;
            case LOADING_SCREEN:
                loadingScreen.update();
                break;
            default:
                System.out.println("WARNING - Update - Can't find scene");
                mainMenu.update();
        }
    }

    /**
     * Setup the scene corresponding to a state, and then, its panel.
     * */
    private void setupScene(GameState.State state){
        cardLayout.show(mainPanel, state.name());
        setupPanel(state);
        updateScenePaint();
    }

    /**
     * Setup the panel corresponding to a state.
     * */
    private void setupPanel(GameState.State state){
        JPanel panel = getPanelInstance(state);

        // Handlers
        panel.setFocusable(true);
        panel.addMouseListener(Handlers.mouseH);
        panel.addMouseMotionListener(Handlers.mouseMotionH);
        panel.addKeyListener(Handlers.keyH);
        panel.requestFocus();

        // Position
        panel.setPreferredSize(new Dimension(GameSettings.screenWidth, GameSettings.screenHeight));
        panel.setBounds(0, 0, GameSettings.screenWidth, GameSettings.screenHeight);

        // Others
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        updateScenePaint();
    }

    public static void updateScenePaint(){
        mainPanel.repaint();
        mainPanel.revalidate();
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
            case LOADING_SCREEN:
                return loadingScreen;
            default:
                // Warning only if I'm not exiting the game.
                if (!state.name().equals(GameState.State.QUIT.name())) {
                    System.out.println("WARNING - getPanelInstance - Non riesco a trovare l'istanza voluta: '" + state.name() +  "'!");
                }
                return mainMenu;
        }
    }

    private void drawScene(GameState.State state){
        switch (state) {
            case MAIN_MENU -> mainMenu.repaint();
            case PLAY -> play.repaint();
            case TILE_MAP_GENERATOR -> tmapgen.repaint();
            case TEST -> test.repaint();
            case LOADING_SCREEN -> loadingScreen.repaint();
            default -> {
                if (!state.name().equals(GameState.State.QUIT.name())) {
                    System.out.println("WARNING - drawScene - Non ho trovato lo stato che vorresti disegnare!");
                }
                mainMenu.repaint();
            }
        }
    }

    private void stop(){
        isRunning = false;
    }
}
