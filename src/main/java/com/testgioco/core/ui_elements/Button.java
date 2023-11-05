package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Button {
    private Box box;
    private Label label;
    private JPanel panel;
    private Vector2DInt vector;
    private int width;
    private int height;
    private int bordThickness;
    private Color buttonColor;
    private String text;

    public Button(JPanel panel, Vector2DInt vector, int width, int height, String text, int bordThickness,
                  Color buttonColor){
        this.vector = vector;
        this.panel = panel;
        this.width = width;
        this.height = height;
        this.text = text;
        this.bordThickness = bordThickness;
        this.buttonColor = buttonColor;
    }
    private void setBox(){
        box = new Box(vector, width, height, bordThickness, buttonColor);
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
        label = new Label(vector, text);
        int textWidth = g2.getFontMetrics().stringWidth(label.getText());
        int textHeight = g2.getFontMetrics().getHeight();

        int midLabelHeight = textHeight / 2;

        Vector2DInt centerBox = box.getBoxCenter();
        Vector2DInt label_vector = new Vector2DInt(centerBox.getX() - textWidth, centerBox.getY() + midLabelHeight);
        label.setVector(label_vector);
        label.setFont(new Font("Comic Sans", Font.PLAIN, 28));

        if (box.hasMouseOver()){
            label.setColor(Color.ORANGE);
        }
    }

    public void draw(Graphics2D g2){
        setBox();
        setLabel(g2);

        box.draw(g2);
        label.draw(g2);
    }
}
