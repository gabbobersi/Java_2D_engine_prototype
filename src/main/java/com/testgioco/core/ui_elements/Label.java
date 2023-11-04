package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.exceptions.UnexpectedStringValueException;

import javax.swing.*;
import java.awt.*;

/**
 * This class allows to draw and update text on the screen.
 * */
public class Label  {
    private Font font = new Font("Comic Sans", Font.PLAIN, 15);
    private Vector2DInt vector = new Vector2DInt(0, 0);
    private String text = "";
    private Color color = Color.BLACK;

    /**
     * Custom label with coordinates (x, y) for position.
     * @param x X position.
     * @param y Y position.
     * @param text Text of the label.
     * @param font Font object represent text's font and text's size.
     * @param color Color of the text.
     * */
    public Label(int x, int y, String text, Font font, Color color){
        assignConstructorParametersToInstance(new Vector2DInt(x, y), text, font, color);
    }

    /**
     * Custom label with vector for position.
     * @param vector Vector 2D containing x, y position.
     * @param text Text of the label.
     * @param font Font object represent text's font and text's size.
     * @param color Color of the text.
     * */
    public Label(Vector2DInt vector, String text, Font font, Color color){
        assignConstructorParametersToInstance(vector, text, font, color);
    }

    /**
     * Default label with vector for position.
     * @param vector Vector 2D containing x, y position.
     * @param text Text of the label.
     * */
    public Label(Vector2DInt vector, String text){
        Font font = new Font("Comic Sans", 1, 30);
        assignConstructorParametersToInstance(vector, text, font, Color.BLACK);
    }

    /**
     * Custom label with coordinates (x, y) for position.
     * @param x X position.
     * @param y Y position.
     * @param text Text of the label.
     * */
    public Label(int x, int y, String text){
        assignConstructorParametersToInstance(new Vector2DInt(x, y), text, font, color);
    }

    /**
     * Assign constructors parameters to instance's attributes.
     * @param vector Vector 2D containing x, y position.
     * @param text Text of the label.
     * @param font Font object represent text's font and text's size.
     * @param color Color of the text.
     * */
    private void assignConstructorParametersToInstance(Vector2DInt vector, String text, Font font, Color color){
        this.vector = vector;
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public void draw(Graphics2D g2){
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
