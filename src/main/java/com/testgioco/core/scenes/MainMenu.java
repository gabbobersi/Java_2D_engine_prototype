package com.testgioco.core.scenes;

import com.testgioco.core.Game;
import com.testgioco.core.GameState;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel implements Scene {
    // Buttons settings
    private final int btnHorizontalAlignment = GameSettings.screenWidth /2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private Button playBtn = new Button(new Vector2DInt(btnHorizontalAlignment, 80), btnWidth,
            btnHeight, "Play", bordThickness, btnColor, btnFont);

    private Button tMapGenBtn = new Button(new Vector2DInt(btnHorizontalAlignment, 200), btnWidth,
            btnHeight, "Tmapgen", bordThickness, btnColor, btnFont);

    private Button quitBtn = new Button(new Vector2DInt(btnHorizontalAlignment, 320), btnWidth,
            btnHeight, "Quit", bordThickness, btnColor, btnFont);

    private Button testBtn = new Button(new Vector2DInt(btnHorizontalAlignment,
            GameSettings.screenHeight - btnHeight*2),
            btnWidth,
            btnHeight, "Test", bordThickness, btnColor, btnFont);

    public MainMenu(){super();}

    public void awake(){
        setBackground(Color.BLACK);
        Game.updateScenePaint();
    }

    @Override
    public void update(){
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
    public void fixedUpdate(){}

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

    @Override
    public void unload(int delay){}
}
