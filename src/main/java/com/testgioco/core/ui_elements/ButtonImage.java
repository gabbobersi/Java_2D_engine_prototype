package com.testgioco.core.ui_elements;

import com.testgioco.core.Cell;
import com.testgioco.core.Vector2DInt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ButtonImage{
    private final JPanel panel;
    private Cell cell = new Cell();
    private final int width;
    private final int height;
    private final int bordThickness;
    private Vector2DInt vector;
    public int id;

    private final BoxImage boxImage;
    private final Image image;

    private boolean isBright = false;
    private boolean isClicked = false;

    public ButtonImage(JPanel panel, Vector2DInt vector, int width, int height, int bordThickness, BufferedImage image){
        this.vector = vector;
        this.panel = panel;
        this.width = width;
        this.height = height;
        this.bordThickness = bordThickness;
        this.image = new Image(image);
        boxImage = new BoxImage(vector, width, height, bordThickness, this.image.getImage());
    }

    public void draw(Graphics2D g2){
        if ((isClicked() || isPressed()) && !isClicked){
            isClicked = true;
            isBright = false;
            brightImage(500);
        } else if (!isClicked() && !isPressed() && isClicked){
            isClicked = false;
            isBright = false;
            resetImage();
        }

        if (boxImage.hasMouseOver() && !isBright && !isClicked){
            isBright = true;
            brightImage(100);
        } else if (!boxImage.hasMouseOver() && isBright && !isClicked){
            isBright = false;
            resetImage();
        }



        boxImage.draw(g2);
    }

    public void setVector(Vector2DInt vector){
        this.vector = vector;
        boxImage.setX(this.vector.getX());
        boxImage.setY(this.vector.getY());
    }

    public boolean isClicked(){
        return boxImage.hasBeenClicked();
    }

    public boolean isPressed(){
        return boxImage.hasBeenPressed();
    }

    private void brightImage(int pixelAmount){
        image.brightImage(pixelAmount);
        boxImage.setImage(image.getImage());
    }

    private void resetImage(){
        image.resetImage();
        boxImage.setImage(image.getImage());
    }
}
