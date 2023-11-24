package com.testgioco.core;

public class World {
    private final Cell cell = new Cell();

    public int maxColumn = 100;
    public int maxRow = 100;
    public int width = cell.width * maxColumn;
    public int height = cell.height * maxColumn;

}
