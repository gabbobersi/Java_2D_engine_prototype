package com.testgioco.entities.base_classes;

import com.testgioco.utilities.Vector2D;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    // Sprites
    protected BufferedImage up1, up2;
    protected BufferedImage down1, down2;
    protected BufferedImage left1, left2;
    protected BufferedImage right1, right2;

    // Positions
    public Vector2DInt positionOnTheMap;
    public Vector2D positionOnTheScreen;

    // Collisions
    public boolean isCollidingVertically = false;
    public boolean isCollidingHorizontally = false;
    public Rectangle solidArea;       // Indicates the solid area of the entity, under collision.
}

