package com.testgioco.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.CollisionManager;
import com.testgioco.core.tile.TileManager;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.inventory.InventoryManager;
import com.testgioco.entities.Player;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Handlers;

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
        Handlers.keyH.reset();
    }

    @Override
    public void update(){
        if (Handlers.keyH.esc_pressed){
            GameState.setNextState(GameState.State.LOADING_SCREEN);
            Handlers.keyH.reset();
        }

        collisionManager.checkCollision(tileManager, player);
        player.update();

        if (Handlers.keyH.i_pressed){
            player.setVisible(!player.isVisible());
        }

        if (Handlers.keyH.space_pressed){
            inventoryManager.setVisible(!inventoryManager.isVisible());
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
        collisionManager.drawCollision(g2, player);

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
