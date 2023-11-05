package com.testgioco.core.scenes;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{
    private GameSettings settings = new GameSettings();

    private int btnHorizontalAlignment = settings.screenWidth/2 - 75;
    private Button playBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 80), 150,
            80, "Play", 6, Color.GRAY);

    private Button tMapGenBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 200), 150,
            80, "Tmapgen", 6, Color.GRAY);

    private Button quitBtn = new Button(this, new Vector2DInt(btnHorizontalAlignment, 320), 150,
            80, "Quit", 6, Color.GRAY);

    public MainMenu(){
        setBackground(Color.WHITE);

        addKeyListener(Singletons.keyH);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);

        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Objects to draw, in order.

        playBtn.draw(g2);
        tMapGenBtn.draw(g2);
        quitBtn.draw(g2);
        g2.dispose();
    }
}
