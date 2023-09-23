package com.testgioco;


public class Grid {
    Cell cell = new Cell();
    public int columnNumber = 16;
    public int cowNumber = 40;
    int columnPixels = columnNumber * cell.size;        // Final column dimension
    int rowPixels = cowNumber * cell.size;            // Final row dimension
}
