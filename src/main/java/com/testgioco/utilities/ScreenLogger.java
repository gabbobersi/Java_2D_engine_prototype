package com.testgioco.utilities;

import com.testgioco.core.Cell;
import com.testgioco.core.Grid;

import java.awt.*;

public class ScreenLogger {
    private final GameSettings settings = new GameSettings();
    private final Cell cell = new Cell();
    private final Grid grid = new Grid();

    public void draw(Graphics2D g2){
        int x = 10;
        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));
        g2.drawString("Risoluzione: " + settings.screenWidth + " x " + settings.screenHeight, x, 20);
        g2.drawString("Numero colonne: " + grid.columnNumber, x, 40);
        g2.drawString("Numero righe: " + grid.rowNumber, x, 60);
        g2.drawString("Dimensione cella: " + cell.width + " x " + cell.height, x, 80);
        g2.drawString("========== COMANDI ==========", x, 120);
        g2.drawString("> ESC == Torna al menu principale", x, 140);

    }

}
