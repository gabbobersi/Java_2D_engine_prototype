package com.testgioco.scenes;

import com.testgioco.core.Game;
import com.testgioco.core.GameState;
import com.testgioco.core.ui_elements.button.ButtonLabel;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
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

    private ButtonLabel playBtn = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 80), btnWidth,
            btnHeight, "Play", bordThickness, btnColor, btnFont);

    private ButtonLabel tMapGenBtn = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 200), btnWidth,
            btnHeight, "Tmapgen", bordThickness, btnColor, btnFont);

    private ButtonLabel quitBtn = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment, 320), btnWidth,
            btnHeight, "Quit", bordThickness, btnColor, btnFont);

    private ButtonLabel testBtn = new ButtonLabel(new Vector2DInt(btnHorizontalAlignment,
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
        if (quitBtn.hasBeenClicked()) {
            GameState.setNextState(GameState.State.QUIT);
        } else if (playBtn.hasBeenClicked()){
            GameState.setNextState(GameState.State.LOADING_SCREEN);
        } else if (tMapGenBtn.hasBeenClicked()){
            GameState.setNextState(GameState.State.TILE_MAP_GENERATOR);
        } else if (testBtn.hasBeenClicked()){
            GameState.setNextState(GameState.State.TEST);
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
