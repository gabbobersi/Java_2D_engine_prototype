package com.testgioco;

import com.testgioco.ui_elements.Cell;
import com.testgioco.ui_elements.Grid;
import com.testgioco.ui_elements.Window;

import java.awt.*;

public class Debug {
    Graphics2D g2;
    Cell cell = new Cell();
    Grid grid = new Grid();
    Window windows = new Window();

    public Debug(Graphics2D g2){
        this.g2 = g2;
    }
    public void draw(){
        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));
        g2.drawString("Risoluzione: " + windows.getWidth() + " x " + windows.getHeight(), 10, 20);
        g2.drawString("Numero colonne: " + grid.columnNumber, 10, 40);
        g2.drawString("Numero righe: " + grid.rowNumber, 10, 60);
        g2.drawString("Dimensione cella: " + cell.size + " x " + cell.size, 10, 80);
    }

}
