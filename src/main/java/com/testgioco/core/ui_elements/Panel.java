package com.testgioco.core.ui_elements;

import com.testgioco.core.Grid;
import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.core.InputHandler;
import com.testgioco.entities.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final InputHandler keyH;
    private final GameSettings settings = new GameSettings();

    // Here put classes to draw
    public final TileManager tileManager = new TileManager();
    public final Grid grid = new Grid();
    public final Player player = new Player();
    public final ScreenLogger debug = new ScreenLogger();

    private Label label1 = new Label(200, 400, "Test", new Font("Comic Sans", Font.PLAIN, 30), Color.BLACK);
    private Label label = new Label(new Vector2DInt(100, 100), "Test nuovo daje");

    public Panel(InputHandler keyH, Color backGround){
        this.keyH = keyH;
        player.keyH = keyH;
        setBackground(Color.WHITE);
        addKeyListener(this.keyH);
        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));

        setLayout(null);

        label.setVector(new Vector2DInt(100, 100));
        label1.setVector(new Vector2DInt(200, 400));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // Objects to draw, in order.
//        tileManager.draw(g2);
//        grid.drawDebugGrid(g2);
//        debug.draw(g2);
//        player.draw(g2);
        label.draw(g2);
        label1.draw(g2);
        g2.dispose();
    }
}
