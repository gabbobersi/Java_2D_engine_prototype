package com.testgioco.core.ui_elements.inventory;

import com.testgioco.utilities.Image;

public class Item {
    private String name;
    private String description;
    private Image image;

    public Item(String name, String description, Image image){
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Image getImage(){
        return image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImage(Image image){
        this.image = image;
    }
}
