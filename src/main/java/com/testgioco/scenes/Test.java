package com.testgioco.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.ui_elements.button.ButtonLabel;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.bars.BarManager;
import com.testgioco.core.ui_elements.inventory.InventoryManager;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Handlers;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel implements Scene {
    private final int btnHorizontalAlignment = GameSettings.screenWidth / 2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private final ButtonLabel btnTest = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight,
            "test", bordThickness, btnColor, btnFont);

    private final ButtonLabel btnResetCounter = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 200), btnWidth, btnHeight,
            "Reset counter", bordThickness, btnColor, btnFont);

    private final ButtonLabel btnMainMenu = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 500), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private BarManager barManager = new BarManager(new Vector2DInt(100, 100));
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
        if (btnTest.hasBeenClicked()){
        } else if (btnResetCounter.hasBeenClicked()){
        } else if (btnMainMenu.hasBeenClicked()){
            GameState.setNextState(GameState.State.MAIN_MENU);
        }

        if (Handlers.keyH.space_pressed){
            barManager.reduceHealth(10);
        } else if (Handlers.keyH.a_pressed){
            barManager.resetHealth();
        }
    }

    @Override
    public void fixedUpdate(){}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        String counterOfClick = btnTest.getText() + " clicked: " + Handlers.mouseH.clickCount + " times";
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