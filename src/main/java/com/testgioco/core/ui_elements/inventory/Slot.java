package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.ui_elements.ButtonImage;
import com.testgioco.core.ui_elements.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Slot {
    private int id;
    private final ButtonImage buttonImage;
    private Item item;
    private BufferedImage defaultImage;

    public Slot(JPanel panel, Vector2DInt position, Dimension dimension, BufferedImage defaultImage){
        this.defaultImage = defaultImage;
        buttonImage = new ButtonImage(panel, position, dimension.width, dimension.height, 4, defaultImage);
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setPosition(Vector2DInt position){
        buttonImage.setVector(position);
    }

    public void draw(Graphics2D g2){
        buttonImage.draw(g2);
    }

    public boolean isClicked(){
        return buttonImage.isClicked();
    }

    public boolean isPressed(){
        return buttonImage.isPressed();
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
