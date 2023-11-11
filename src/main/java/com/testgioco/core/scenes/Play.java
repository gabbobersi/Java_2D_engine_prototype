package com.testgioco.core.scenes;

import com.testgioco.core.Grid;
import com.testgioco.core.TileManager;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Play extends JPanel{
    private final GameSettings settings = new GameSettings();
    private final TileManager tileManager = new TileManager();
    private final Grid grid = new Grid();
    private final ScreenLogger debug = new ScreenLogger();
    private final Player player = new Player();
    private final InputHandler inputHandler = new InputHandler();

    public Play(){
        super();
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Play Panel has gained focus");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Play Panel has lost focus");
            }
        });
        setBackground(Color.WHITE);
        addKeyListener(inputHandler);
//        addMouseListener(Singletons.mouseH);
//        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);

        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));

        requestFocus();
        System.out.println("Has focus: " + isFocusOwner());

    }

    public void run(){

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        grid.drawDebugGrid(g2);
        debug.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

    public void processInput(){
        player.getInput();
    }

    public void updateGame(){
        player.update();
    }
}
