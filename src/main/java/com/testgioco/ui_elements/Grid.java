package com.testgioco.ui_elements;


public class Grid {
    private Cell cell = new Cell();
    private Window window = new Window();

    public int columnNumber = window.getWidth() / cell.size;
    public int rowNumber = window.getHeight() / cell.size;;
}
