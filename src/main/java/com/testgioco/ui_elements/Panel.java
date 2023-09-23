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
        // Game loop
        while (true) {
            if (fps.canDraw(true)){
                // Manca il metodo di update(). DA FARE
                repaint();
            }
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.dispose();
    }
}
