package com.testgioco;


public class Grid {
    public Cell cell = new Cell();
    public int columnNumber = 16;
    public int rowNumber = 40;
    int columnPixels = columnNumber * cell.size;        // Final column dimension
    int rowPixels = rowNumber * cell.size;            // Final row dimension
}
