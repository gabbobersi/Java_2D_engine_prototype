package com.testgioco.utilities;

import com.testgioco.core.Cell;
import com.testgioco.core.Grid;

import java.awt.*;

public class ScreenLogger {
    private final GameSettings settings = new GameSettings();
    private final Cell cell = new Cell();
    private final Grid grid = new Grid();

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));
        g2.drawString("Risoluzione: " + settings.screenWidth + " x " + settings.screenHeight, 10, 20);
        g2.drawString("Numero colonne: " + grid.columnNumber, 10, 40);
        g2.drawString("Numero righe: " + grid.rowNumber, 10, 60);
        g2.drawString("Dimensione cella: " + cell.width + " x " + cell.height, 10, 80);
    }

}
