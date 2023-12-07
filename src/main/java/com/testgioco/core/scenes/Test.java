package com.testgioco.core.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.ButtonImage;
import com.testgioco.core.ui_elements.bars.BarManager;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.core.ui_elements.inventory.InventoryManager;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test extends JPanel implements Scene {
    private final int btnHorizontalAlignment = GameSettings.screenWidth / 2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private final Button btnTest = new Button(new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight,
            "test", bordThickness, btnColor, btnFont);

    private final Button btnResetCounter = new Button(new Vector2DInt(btnHorizontalAlignment, 200), btnWidth, btnHeight,
            "Reset counter", bordThickness, btnColor, btnFont);

    private final Button btnMainMenu = new Button(new Vector2DInt(btnHorizontalAlignment, 500), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private BarManager barManager = new BarManager();
    private final InventoryManager inventory;

    public Test(){
        super();
        GridLayout grid = new GridLayout(2, 1);
        setLayout(grid);
        inventory = new InventoryManager(this, 2, 4, 50, 50, 3);
    }

    public void awake(){

    }

    @Override
    public void update() {
        if (btnTest.isClicked()){
        } else if (btnResetCounter.isClicked()){
        } else if (btnMainMenu.isClicked()){
            GameState.setActiveState(GameState.State.MAIN_MENU);
        }

        if (Singletons.keyH.spacePressed){
            barManager.reduceHealth(10);
        } else if (Singletons.keyH.leftPressed){
            barManager.resetHealth();
        }
    }

    @Override
    public void fixedUpdate(){}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        String counterOfClick = btnTest.getText() + " clicked: " + Singletons.mouseH.clickCount + " times";
        g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        g2.drawString(counterOfClick, 150, 80);

        btnResetCounter.draw(g2);
        btnTest.draw(g2);
        btnMainMenu.draw(g2);

//        inventory.draw(g2);
        g2.dispose();
    }

    @Override
    public void unload(int delay){}
}