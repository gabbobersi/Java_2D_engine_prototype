package com.testgioco.ui_elements;

import com.testgioco.Fps;
import com.testgioco.Grid;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    Grid grid = new Grid();
    Fps fps = new Fps(60);

    Thread gameThread;
    public Panel(){
        // COSTRUTTORE
    }
    @Override
    public void run() {
        // Main game loop
        while (gameThread != null) {
            // Note: we only updates and draw when fps allow us.
            if (fps.canDraw(true)){
                update();
                repaint();  // Calls "paintComponent" method.
            }
        }
    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start();     // It calls "run()" method.
    }

    public void update(){

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(100, 100, grid.cell.size, grid.cell.size);
        g2.dispose();
    }
}
