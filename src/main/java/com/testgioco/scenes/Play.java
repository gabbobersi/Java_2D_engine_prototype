package com.testgioco.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.CollisionManager;
import com.testgioco.core.tile.TileManager;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.bars.BarManager;
import com.testgioco.core.ui_elements.inventory.InventoryManager;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Handlers;
import com.testgioco.utilities.Vector2DInt;

import javax.swing.*;
import java.awt.*;

public class Play extends JPanel implements Scene {
    private TileManager tileManager;
    private ScreenLogger screenLogger;
    private Player player;
    private CollisionManager playerCollisionManager;
    private InventoryManager inventoryManager;
    private BarManager barManager;

    public Play(){
        super();
    }

    @Override
    public void awake(){
        System.out.println("AWAKE");
        screenLogger = new ScreenLogger(new Vector2DInt(10, 20));
        player = new Player();
        tileManager = new TileManager(player);
        tileManager.loadMap("/maps/tmapgen_1.txt");
        playerCollisionManager = new CollisionManager(tileManager, player);
        inventoryManager = new InventoryManager(this, 2, 4, 50, 50, 7);
        Handlers.keyH.reset();

        barManager = new BarManager(new Vector2DInt(10, GameSettings.screenHeight - 50));
        // AudioMaster.play("assets/audio/background/test_1_npc.wav");
    }

    @Override
    public void update(){
        if (Handlers.keyH.esc_pressed){
            GameState.setNextState(GameState.State.LOADING_SCREEN);
            Handlers.keyH.reset();
        }

        playerCollisionManager.checkCollision();
        player.update();

        if (Handlers.keyH.i_pressed){
            player.setVisible(!player.isVisible());
        }

        if (Handlers.keyH.space_pressed){
            inventoryManager.setVisible(!inventoryManager.isVisible());
        }

        if (Handlers.keyH.h_pressed){
            screenLogger.setVisible(!screenLogger.isVisible());
        }
    }

    @Override
    public void fixedUpdate(){
//        System.out.println("Player x: " + player.getPositionOnTheMap().getX() + " y: " + player.getPositionOnTheMap().getY());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if (tileManager == null || player == null || playerCollisionManager == null || inventoryManager == null || screenLogger == null){
            return;
        }

        tileManager.draw(g2);
        screenLogger.draw(g2);
        player.draw(g2);
        inventoryManager.draw(g2);
        playerCollisionManager.drawCollision(g2, player);
        barManager.draw(g2);
    }

    @Override
    public void unload(int delay){
        Timer unloadTimer = new Timer(delay, e -> {
            System.out.println("UNLOAD");
            tileManager = null;
            player = null;
            playerCollisionManager = null;
            inventoryManager = null;
            screenLogger = null;
        });
        unloadTimer.setRepeats(false);
        unloadTimer.start();
    }
}
