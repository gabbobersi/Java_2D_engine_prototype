package com.testgioco.core;

import com.testgioco.core.scenes.LoadingScreen;
import com.testgioco.core.scenes.MainMenu;
import com.testgioco.core.scenes.Play;
import com.testgioco.core.scenes.Test;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;
import com.tilemapgenerator.TileMapGenerator;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable {
    private final Constants constants = new Constants();
    private Thread gameThread;
    private volatile boolean isRunning = true;

    private final Window window;
    private final JPanel mainPanel;
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
        mainPanel = new JPanel();
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
        setupScene(GameSettings.defaultScene);
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

        int fps = 0;
        double fpsTimer = 0;
        double fixedUpdateTimer = 0;
        while (isRunning){
            GameState.State activeState = GameState.getActiveState();

            double current = System.nanoTime();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;

            if (GameState.getPreviousState() != GameState.getActiveState()){
                System.out.println("Cambio scena: da " + GameState.getPreviousState() + " a " + GameState.getActiveState());
                // Changing scene actions.
                unloadScene(GameState.getPreviousState(), 80);
                changeScene(activeState);
                awakeScene(activeState);
            }

            // In this while, FPS limit execution.
            while (lag >= constants.NANOSECONDS_PER_UPDATE){
                updateGame(activeState);
                lag -= constants.NANOSECONDS_PER_UPDATE;
                updateScene(activeState);
                fps++;
            }

            processInput(activeState);
            drawScene(activeState);

            // When 0.2 (constants) seconds is passed, execute the fixedUpdate of the scene.
            fixedUpdateTimer += elapsed;
            if (fixedUpdateTimer >= constants.NANOSECONDS_PER_FIXED_UPDATE){
                fixedUpdateTimer = 0;
                fixedUpdateScene(activeState);
            }

            // When a second is passed, print the FPS.
            fpsTimer += elapsed;
            if (fpsTimer >= constants.ONE_SECOND_IN_NANOSECONDS) {
//                System.out.println("FPS: " + fps);
                fps = 0;
                fpsTimer = 0;
            }
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

    private void changeScene(GameState.State state){
        GameState.setActiveState(state);
        setupPanel(state);
        Singletons.mouseH.reset();
        setupScene(state);
    }

    private void awakeScene(GameState.State state){
        switch (state){
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
                System.out.println("WARNING - Awake - Can't find scene");
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
                System.out.println("WARNING - Unload - Can't find scene");
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
                System.out.println("WARNING - Eseguo il run di mainMenu perché non ho trovato lo stato che ti " +
                        "interessa!");
                mainMenu.update();
        }
    }

    /**
     * Setup the scene corresponding to a state, and then, its panel.
     * */
    private void setupScene(GameState.State state){
        cardLayout.show(mainPanel, state.name());
        setupPanel(state);
        mainPanel.repaint();
        mainPanel.revalidate();
        window.repaint();
        window.revalidate();
    }

    /**
     * Setup the panel corresponding to a state.
     * */
    private void setupPanel(GameState.State state){
        JPanel panel = getPanelInstance(state);

        // Handlers
        panel.setFocusable(true);
        panel.addMouseListener(Singletons.mouseH);
        panel.addMouseMotionListener(Singletons.mouseMotionH);
        panel.addKeyListener(Singletons.keyH);
        panel.requestFocus();

        // Position
        panel.setPreferredSize(new Dimension(GameSettings.screenWidth, GameSettings.screenHeight));
        panel.setBounds(0, 0, GameSettings.screenWidth, GameSettings.screenHeight);

        // Others
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

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
