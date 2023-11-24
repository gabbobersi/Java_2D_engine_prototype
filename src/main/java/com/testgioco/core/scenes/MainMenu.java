package com.testgioco.core.scenes;

import com.testgioco.core.Game;
import com.testgioco.core.GameState;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel implements Scene {
    private GameSettings settings = new GameSettings();

    // Buttons settings
    private final int btnHorizontalAlignment = settings.screenWidth/2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private Button playBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 80), btnWidth,
            btnHeight, "Play", bordThickness, btnColor, btnFont);

    private Button tMapGenBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 200), btnWidth,
            btnHeight, "Tmapgen", bordThickness, btnColor, btnFont);

    private Button quitBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 320), btnWidth,
            btnHeight, "Quit", bordThickness, btnColor, btnFont);

    private Button testBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 500), btnWidth,
            btnHeight, "Test", bordThickness, btnColor, btnFont);

    public MainMenu(){
        super();
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    public void awake(){

    }

    @Override
    public void fixedUpdate(){
        if (quitBtn.isClicked()) {
            GameState.setActiveState(GameState.State.QUIT);
        } else if (playBtn.isClicked()){
            GameState.setActiveState(GameState.State.PLAY);
        } else if (tMapGenBtn.isClicked()){
            GameState.setActiveState(GameState.State.TILE_MAP_GENERATOR);
        } else if (testBtn.isClicked()){
            GameState.setActiveState(GameState.State.TEST);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Objects to draw, in order.
        playBtn.draw(g2);
        tMapGenBtn.draw(g2);
        quitBtn.draw(g2);
        testBtn.draw(g2);
        g2.dispose();
    }
}
