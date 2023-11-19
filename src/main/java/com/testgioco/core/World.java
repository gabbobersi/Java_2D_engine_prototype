package com.testgioco.core;

public class World {
    private final Cell cell = new Cell();
    private final Grid grid = new Grid();

    public int maxColumn = grid.columnNumber;
    public int maxRow = grid.rowNumber;
    public int width = cell.width * maxColumn;
    public int height = cell.height * maxColumn;

}
