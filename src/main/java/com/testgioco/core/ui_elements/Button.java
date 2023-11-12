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
    }
    private void setBox(){
        box.setX(vector.getX());
        box.setY(vector.getY());
        box.setWidth(width);
        box.setHeight(height);
        box.setThickness(bordThickness);
        box.setColor(buttonColor);
        panel.add(box);

        if (box.hasBeenClicked()){
            box.setColor(Color.BLUE);
        }
        if (Singletons.mouseH.released){
            box.setColor(buttonColor);
        }
    }

    private void setLabel(Graphics2D g2){
        // X center pos
        int textWidth = g2.getFontMetrics().stringWidth(label.getText());
        int midLabelWidth = (int)Math.round((double)textWidth / 2);
        int xPos = vector.getX() + width / 2 - midLabelWidth;

        // Y center pos
        int textHeight = g2.getFontMetrics().getDescent() + g2.getFontMetrics().getDescent() + g2.getFontMetrics().getLeading();
        int midLabelHeight = textHeight / 2;
        int yPos = vector.getY() + height / 2 + midLabelHeight;

        Vector2DInt label_vector = new Vector2DInt(xPos, yPos);
        label.setVector(label_vector);

        if (box.hasMouseOver()){
            label.setColor(Color.ORANGE);
        } else {
            label.setColor(Color.BLACK);
        }
    }

    public boolean isClicked(){
        return box.hasBeenClicked();
    }

    public void draw(Graphics2D g2){
        setBox();
        box.draw(g2);
        label.draw(g2);

        // After drawing, so "g2.setFont" happens at the right time inside the label
        setLabel(g2);
    }
}
