package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class World {
    private Cell cell = new Cell();
    private Grid grid = new Grid();

    public int maxColumn = grid.columnNumber;
    public int maxRow = grid.rowNumber;
    public int width = cell.width * maxColumn;
    public int height = cell.height * maxColumn;

}
