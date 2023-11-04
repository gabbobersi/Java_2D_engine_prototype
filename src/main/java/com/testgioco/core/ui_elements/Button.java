package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;
import com.testgioco.core.Vector2DInt;

import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.geom.Rectangle2D;

public class Button {
    private Box box;
    private Label label;
    private Panel panel;
    private Vector2DInt vector;
    private int width;
    private int height;
    private int bordThickness;
    private Color buttonColor;
    private String text;

    public Button(Panel panel, Vector2DInt vector, int width, int height, String text, int bordThickness,
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
        box.setBoxColor(buttonColor);
        panel.add(box);
    }

    private void setLabel(Graphics2D g2){
        label = new Label(vector, text);
        int textWidth = g2.getFontMetrics().stringWidth(label.getText());
        int textHeight = g2.getFontMetrics().getHeight();

        int midLabelHeight = textHeight / 2;

        Vector2DInt centerBox = box.getBoxCenter();
        Vector2DInt label_vector = new Vector2DInt(centerBox.getX() - textWidth, centerBox.getY() + midLabelHeight);

        Point mouseCoordinates = MouseInfo.getPointerInfo().getLocation();
        System.out.println(mouseCoordinates);
        if (mouseCoordinates.x < vector.getX() && mouseCoordinates.y < vector.getY()){
            System.out.println("SONO QUI DIO BESTIA");
            label.setColor(Color.YELLOW);
        }

        label.setVector(label_vector);
        label.setFont(new Font("Comic Sans", Font.PLAIN, 28));
    }

    public void draw(Graphics2D g2){
        setBox();
        setLabel(g2);

        box.draw(g2);
        label.draw(g2);
    }
}
