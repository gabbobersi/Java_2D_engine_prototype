package com.testgioco.core.ui_elements.bars;

import com.testgioco.utilities.Vector2DInt;

import java.awt.*;

public class Health {
    private Vector2DInt position;
    private int startingWidth;
    private int width;
    private int height;

    public Health(Vector2DInt position, int width, int height){
        this.position = position;
        startingWidth = width;
        this.width = width;
        this.height = height;
    }

    public void reset(){
        width = startingWidth;
    }

    public void reduce(int value){
        width -= value;
        if (width < 5){
            width = 5;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillRect(position.getX(), position.getY(), width, height);
    }

}
