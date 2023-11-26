package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ButtonImage{
    private final JPanel panel;
    private final int width;
    private final int height;
    private final int bordThickness;
    private Vector2DInt vector;
    public int id;

    private BoxImage boxImage;
    private BufferedImage image;

    public ButtonImage(JPanel panel, Vector2DInt vector, int width, int height, int bordThickness, BufferedImage image){
        this.vector = vector;
        this.panel = panel;
        this.width = width;
        this.height = height;
        this.bordThickness = bordThickness;
        this.image = image;

        boxImage = new BoxImage(vector, width, height, bordThickness, image);
    }

    public void draw(Graphics2D g2){
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

    public void modifyImage(int R, int G, int B){
        Color color = new Color(R, G, B);
        int rgb = color.getRGB();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i, j, rgb);
            }
        }
        boxImage.setImage(image);
    }
}
