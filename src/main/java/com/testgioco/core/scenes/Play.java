package com.testgioco.core.scenes;

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
    private final ScreenLogger debug = new ScreenLogger();
    private Player player;
    private CollisionManager collisionManager;
    private InventoryManager inventoryManager;
    private boolean drawInventory = false;

    public Play(){
        super();
    }

    @Override
    public void awake(){
        System.out.println("AWAKE");
        player = new Player();
        tileManager = new TileManager(player);
        tileManager.loadMap("/maps/tmapgen_1.txt");
        collisionManager = new CollisionManager();
        inventoryManager = new InventoryManager(this, 2, 4, 50, 50, 7);
    }

    @Override
    public void update(){
        if (Singletons.keyH.escPressed){
            GameState.setActiveState(GameState.State.MAIN_MENU);
            Singletons.keyH.reset();
        }
        drawInventory = Singletons.keyH.i_pressed;
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

        if (drawInventory){
            inventoryManager.draw(g2);
        }

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
    public void unload(){
        System.out.println("UNLOAD");
        tileManager = null;
        player = null;
        collisionManager = null;
        inventoryManager = null;
    }
}
