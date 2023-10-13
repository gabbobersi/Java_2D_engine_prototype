package com.testgioco.ui_elements;

import com.testgioco.utilities.Constants;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.core.Fps;
import com.testgioco.utilities.GameSettings;
import com.testgioco.core.InputHandler;
import com.testgioco.entities.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    private final GameSettings settings = new GameSettings();
    private final Constants constants = new Constants();

    private final Fps fps = new Fps();
    private final InputHandler keyH = new InputHandler();
    private Thread gameThread;
    private final Player player = new Player(keyH);
    private final TileManager tileManager = new TileManager();

    public Panel() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    @Override
    public void run() {
        // Main game loop
//        while (gameThread != null) {
//            // Note: we only updates and draw when fps allow us.
//            if (fps.canDraw_accumulator(true)){
//                update();
//                repaint();  // Calls "paintComponent" method.
//            }
//        }
        double drawInterval = (double)constants.ONE_SECOND_IN_MILLISECONDS / settings.fps;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {
            update();
            repaint();
            fps.canDraw_sleep(true);
        }


    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start(); // Calls "run" method, in a new thread.
    }

    public void update(){
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        player.draw(g2);

        ScreenLogger debug = new ScreenLogger(g2);
        debug.draw();
        g2.dispose();
    }
}
