package com.testgioco.utilities;

import java.awt.*;

public class ScreenLogger {

    public void draw(Graphics2D g2){
        int x = 10;

        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));
        g2.drawString("Risoluzione: " + GameSettings.screenWidth + " x " + GameSettings.screenHeight, x, 20);
        g2.drawString("Numero colonne: " + GameSettings.mapColumnsNumber, x, 40);
        g2.drawString("Numero righe: " + GameSettings.mapRowsNumber, x, 60);
        g2.drawString("Dimensione cella: " + Constants.cellWidth + " x " + Constants.cellHeight, x, 80);
        g2.drawString("========== COMANDI ==========", x, 120);
        g2.drawString("> ESC == Menu principale", x, 140);
        g2.drawString("> SPACE == Inventario", x, 160);
        g2.drawString("> I == Invisibile", x, 180);
    }

}
