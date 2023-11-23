package com.testgioco.core.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.Grid;
import com.testgioco.core.TileManager;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.entities.Player;
import com.testgioco.entities.collision_manager.CollisionManager;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Play extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();
    private final TileManager tileManager;
    private final Grid grid = new Grid();
    private final ScreenLogger debug = new ScreenLogger();
    private final Player player;
    private final InputHandler inputHandler = new InputHandler();
    private final CollisionManager collisionManager;

    public Play() {
        super();
        addKeyListener(inputHandler);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        player = new Player(inputHandler);
        tileManager = new TileManager(player, "/maps/tmapgen_1.txt");
        tileManager.loadMap();
        collisionManager = new CollisionManager(tileManager, player, inputHandler);
        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    @Override
    public void run() {
        if (inputHandler.escPressed) {
            GameState.setActiveState(GameState.State.MAIN_MENU);
            inputHandler.reset();
        }

        processInput();
        updateGame();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        grid.drawDebugGrid(g2);
        debug.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

    public void processInput() {
        player.getInput();
    }

    public void updateGame() {
        if (collisionManager.canMove()) {
            player.update();
        }
    }
}
