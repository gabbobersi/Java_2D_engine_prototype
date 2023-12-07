package com.testgioco.core.scenes;

import com.testgioco.core.Game;
import com.testgioco.core.GameState;
import com.testgioco.core.CollisionManager;
import com.testgioco.core.tile.TileManager;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.inventory.InventoryManager;
import com.testgioco.entities.Player;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Play extends JPanel implements Scene {
    private TileManager tileManager;
    private ScreenLogger debug;
    private Player player;
    private CollisionManager collisionManager;
    private InventoryManager inventoryManager;

    public Play(){
        super();
    }

    @Override
    public void awake(){
        System.out.println("AWAKE");
        debug = new ScreenLogger();
        player = new Player();
        tileManager = new TileManager(player);
        tileManager.loadMap("/maps/tmapgen_1.txt");
        collisionManager = new CollisionManager();
        inventoryManager = new InventoryManager(this, 2, 4, 50, 50, 7);
    }

    @Override
    public void update(){
        if (Singletons.keyH.escPressed){
            GameState.setActiveState(GameState.State.LOADING_SCREEN);
            Singletons.keyH.reset();
        }

        if (Singletons.keyH.spacePressed){
            inventoryManager.enable();
        }
        if (Singletons.keyH.spacePressed && inventoryManager.isActive()){
            inventoryManager.disable();
        }
    }

    @Override
    public void fixedUpdate(){}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if (tileManager == null || player == null || collisionManager == null || inventoryManager == null){
            return;
        }

        tileManager.draw(g2);
        debug.draw(g2);
        player.draw(g2);
        inventoryManager.draw(g2);

        g2.dispose();
    }

    public void processInput(){
        collisionManager.checkCollision(tileManager, player);
        player.getInput();
    }

    public void updateGame(){
        player.update();
    }

    @Override
    public void unload(int delay){
        Timer unloadTimer = new Timer(delay, e -> {
            System.out.println("UNLOAD");
            tileManager = null;
            player = null;
            collisionManager = null;
            inventoryManager = null;
            debug = null;
        });
        unloadTimer.setRepeats(false);
        unloadTimer.start();
    }
}
