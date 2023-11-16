package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.exceptions.UnexpectedStringValueException;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

/**
 * This class allows to draw and update text on the screen.
 * */
public class Label  {
    private Font font;
    private Vector2DInt vector;
    private String text;
    private Color color;

    /**
     * Custom label with vector for position.
     * @param vector Vector 2D containing x, y position.
     * @param text Text of the label.
     * @param font Font object represent text's font and text's size.
     * @param color Color of the text.
     * */
    public Label(Vector2DInt vector, String text, Font font, Color color){
        this.vector = vector;
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public void draw(Graphics2D g2){
        // Note: font and color are set ONLY during first draw.
        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, vector.getX(), vector.getY());
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Vector2DInt getVector() {
        return vector;
    }

    public void setVector(Vector2DInt vector) {
        this.vector = vector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
