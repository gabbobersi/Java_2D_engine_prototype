package com.testgioco;

import com.testgioco.ui_elements.Cell;
import com.testgioco.ui_elements.Grid;
import com.testgioco.ui_elements.Window;

public class Debug {
    Cell cell = new Cell();
    Grid grid = new Grid();
    Window windows = new Window();

    public void debug(){
        System.out.println("Risoluzione: " + windows.getWidth() + " x " + windows.getHeight());
        System.out.println("Numero colonne: " + grid.columnNumber);
        System.out.println("Numero righe: " + grid.rowNumber);
        System.out.println("Dimensione cella: " + cell.size + " x " + cell.size);
    }

}
