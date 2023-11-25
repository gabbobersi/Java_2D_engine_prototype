package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Button {
    private final Box box;
    private final Label label;
    private final JPanel panel;
    private final Vector2DInt vector;
    private final int width;
    private final int height;
    private final int bordThickness;
    private final Color buttonColor;
    private final String text;
    private final Font font;
    private Vector2DInt vector;

    public Button(JPanel panel, Vector2DInt vector, int width, int height, String text, int bordThickness,
                  Color buttonColor, Font font){
        this.vector = vector;
        this.panel = panel;
        this.width = width;
        this.height = height;
        this.text = text;
        this.bordThickness = bordThickness;
        this.buttonColor = buttonColor;
        this.font = font;

        box = new Box(vector, width, height, bordThickness, buttonColor);
        label = new Label(vector, text, font, Color.BLACK);
        update();
    }
    private void setBox(){
        box.setX(vector.getX());
        box.setY(vector.getY());
        box.setWidth(width);
        box.setHeight(height);
        box.setThickness(bordThickness);
        box.setColor(buttonColor);
        panel.add(box);
    }

    private void setLabel(){
        FontMetrics fontMetrics = new Canvas().getFontMetrics(label.getFont());

        int textWidth = fontMetrics.stringWidth(label.getText());
        int midLabelWidth = (int)Math.round((double)textWidth / 2);
        int xPos = vector.getX() + width / 2 - midLabelWidth;

        int textHeight = fontMetrics.getDescent() + fontMetrics.getDescent() + fontMetrics.getLeading();
        int midLabelHeight = textHeight / 2;
        int yPos = vector.getY() + height / 2 + midLabelHeight;

        Vector2DInt label_vector = new Vector2DInt(xPos, yPos);
        label.setVector(label_vector);
    }

    public boolean isClicked(){
        return box.hasBeenClicked();
    }

    public boolean isPressed(){
        return box.hasBeenPressed();
    }

    public void draw(Graphics2D g2){
        if (isPressed()){
            box.setColor(Color.BLUE);
        } else {
            box.setColor(buttonColor);
        }

        // Label
        if (box.hasMouseOver()){
            label.setColor(Color.ORANGE);
        } else {
            label.setColor(Color.BLACK);
        }

        box.draw(g2);
        label.draw(g2);
    }

    public void setReleased(boolean value){
        Singletons.mouseH.released = value;
    }

    public String getText(){
        return label.getText();
    }

    public void setVector(Vector2DInt vector){
        this.vector = vector;
        update();
    }

    /**
     * Updates button's elements.
     * */
    private void update(){
        setBox();
        setLabel();
    }
}
