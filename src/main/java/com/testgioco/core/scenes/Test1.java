package com.testgioco.core.scenes;

import com.testgioco.core.Grid;
import com.testgioco.core.ui_elements.TileManager;
import com.testgioco.entities.Player;
import com.testgioco.utilities.ScreenLogger;

import javax.swing.*;
import java.awt.*;

public class Test1 extends JPanel{
    public final TileManager tileManager = new TileManager();
    public final Grid grid = new Grid();
    public final Player player = new Player();
    public final ScreenLogger debug = new ScreenLogger();

    public void draw(Graphics2D g2){
        tileManager.draw(g2);
        grid.drawDebugGrid(g2);
        debug.draw(g2);
        player.draw(g2);
    }

}
