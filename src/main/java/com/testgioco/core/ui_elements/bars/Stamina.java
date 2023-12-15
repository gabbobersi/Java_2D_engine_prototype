package com.testgioco.core.ui_elements.bars;

import com.testgioco.core.ui_elements.Label;
import com.testgioco.core.ui_elements.box.BoxColor;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;

public class Stamina {
    private Vector2DInt position;
    private int startingWidth;
    private int width;
    private int height;
    private String text;
    private Label label;
    private BoxColor box;

    public Stamina(Vector2DInt position, int width, int height, String text){
        this.position = position;
        startingWidth = width;
        this.width = width;
        this.height = height;
        this.text = text;
        Font font = new Font("Comic Sans", Font.PLAIN, 15);
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        int yLabel = position.getY() + height/2 + fontMetrics.getDescent();
        label = new Label(new Vector2DInt(position.getX(), yLabel), text, font, Color.BLACK);
        box = new BoxColor(new Vector2DInt(position.getX(), position.getY()), width, height, 4, Color.decode("#a1bf41"));
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
        box.draw(g2);
        label.draw(g2);
    }
}
