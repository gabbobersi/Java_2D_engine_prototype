package com.testgioco.core.scenes;

import com.testgioco.core.GameState;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.bars.BarManager;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel implements Scene {
    GameSettings settings = new GameSettings();

    private final int btnHorizontalAlignment = settings.screenWidth / 2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);
    private final Button btnTest = new Button(this,
            new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight, "test", bordThickness,
            btnColor, btnFont);

    private final Button btnResetCounter = new Button(this,
            new Vector2DInt(btnHorizontalAlignment, 200), btnWidth, btnHeight, "Reset counter", bordThickness,
            btnColor, btnFont);

    private final Button btnMainMenu = new Button(this, new Vector2DInt(btnHorizontalAlignment, 500), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private int counter = 0;

    private final InputHandler inputH = new InputHandler();

    private BarManager barManager = new BarManager();

    public Test(){
        super();
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        addKeyListener(inputH);
        GridLayout grid = new GridLayout(2, 1);
        setLayout(grid);

        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    @Override
    public void run() {
        if (btnTest.isClicked()){
            counter++;
        } else if (btnResetCounter.isClicked()){
            counter = 0;
            btnResetCounter.setReleased(true);
        } else if (btnMainMenu.isClicked()){
            GameState.setActiveState(GameState.State.MAIN_MENU);
        }

        if (inputH.spacePressed){
            barManager.reduceHealth(10);
        } else if (inputH.leftPressed){
            barManager.resetHealth();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        String counterOfClick = btnTest.getText() + " clicked: " + counter + " times";
        g2.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        g2.drawString(counterOfClick, 150, 80);

        btnResetCounter.draw(g2);
        btnTest.draw(g2);
        btnMainMenu.draw(g2);

//        barManager.draw(g2);
        g2.dispose();
    }
}