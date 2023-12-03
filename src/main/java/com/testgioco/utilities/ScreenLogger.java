package com.testgioco.utilities;

import com.testgioco.core.Cell;

import java.awt.*;

public class ScreenLogger {
    private final GameSettings settings = new GameSettings();
    private final Cell cell = new Cell();

    public void draw(Graphics2D g2){
        int x = 10;

        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));
        g2.drawString("Risoluzione: " + settings.screenWidth + " x " + settings.screenHeight, x, 20);
        g2.drawString("Numero colonne: " + GameSettings.mapColumnsNumber, x, 40);
        g2.drawString("Numero righe: " + GameSettings.mapRowsNumber, x, 60);
        g2.drawString("Dimensione cella: " + cell.width + " x " + cell.height, x, 80);
        g2.drawString("========== COMANDI ==========", x, 120);
        g2.drawString("> ESC == Torna al menu principale", x, 140);
        g2.drawString("> I == Inventario", x, 160);

    }

}
