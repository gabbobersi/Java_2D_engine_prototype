package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.ui_elements.button.ButtonImage;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.utilities.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Slot {
    private int id;
    private final ButtonImage buttonImage;
    private Item item;
    private BufferedImage defaultImage;

    public Slot(Vector2DInt positionOnTheScreen, Dimension dimension, BufferedImage defaultImage){
        this.defaultImage = defaultImage;
        buttonImage = new ButtonImage(positionOnTheScreen, dimension.width, dimension.height, 4, defaultImage);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setPositionOnTheScreen(Vector2DInt position){
        buttonImage.setPositionOnTheScreen(position);
    }

    public void draw(Graphics2D g2){
        buttonImage.draw(g2);
    }

    public boolean isClicked(){
        return buttonImage.hasBeenClicked();
    }

    public boolean isPressed(){
        return buttonImage.hasBeenPressed();
    }

    public void setItem(Item item){
        this.item = item;
        if (item == null){
            buttonImage.setImage(new Image(defaultImage));
        } else {
            buttonImage.setImage(item.getImage());
        }
    }

    public Item getItem(){
        return item;
    }
}
