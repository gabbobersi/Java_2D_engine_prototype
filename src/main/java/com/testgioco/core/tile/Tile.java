package com.testgioco.core.tile;

import com.testgioco.utilities.Image;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private boolean collision;
    private String name;

    public Tile(String name, BufferedImage image, boolean collision){
        this.name = name;
        this.image = image;
        this.collision = collision;
    }

    public BufferedImage getImage(){
        return image;
    }

    public boolean hasCollision(){
        return collision;
    }

    public String getName(){
        return name;
    }
}
