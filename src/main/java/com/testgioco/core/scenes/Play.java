package com.testgioco.core.scenes;

import com.testgioco.core.GameState;
import com.testgioco.entities.collision_manager.CollisionManager;
import com.testgioco.utilities.DebugGrid;
import com.testgioco.core.TileManager;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Play extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();
    private final TileManager tileManager;
    private final ScreenLogger debug = new ScreenLogger();
    private final Player player;
    private final InputHandler inputHandler = new InputHandler();
    private final CollisionManager collisionManager;
    private boolean playerCanMove = false;

    public Play(){
        super();
        addKeyListener(inputHandler);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));

        player = new Player(inputHandler);
        tileManager = new TileManager(player);
        collisionManager = new CollisionManager(tileManager, player, inputHandler);
    }

    @Override
    public void awake(){
        System.out.println("AWAKE");
        tileManager.loadMap("/maps/tmapgen_1.txt");
        repaint();
    }

    @Override
    public void fixedUpdate(){
        if (inputHandler.escPressed){
            GameState.setActiveState(GameState.State.MAIN_MENU);
            inputHandler.reset();
        }
        playerCanMove = collisionManager.canMove();

        if (!playerCanMove){
            System.out.println("BLOCCATO");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
//        debugGrid.draw(g2);
        debug.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

    public void processInput(){
        if (tileManager.getTileMap() != null && playerCanMove){
            player.getInput();
        } else {
            player.stopMovement();
        }
    }

    public void updateGame(){
        player.update();
    }
}
