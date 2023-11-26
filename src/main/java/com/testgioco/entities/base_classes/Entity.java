package com.testgioco.entities.base_classes;

import com.testgioco.core.Vector2DInt;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.security.PublicKey;

public class Entity {
    // Sprites
    public BufferedImage up1, up2;
    public BufferedImage down1, down2;
    public BufferedImage left1, left2;
    public BufferedImage right1, right2;

    public int speed;

    // Animations
    public String direction;            // Sprite direction.
    public String defaultDirection = "down";
    public int spriteCounter = 0;       // Number of drawed animations.
    public int spriteNumber = 1;        // Number of the actual animation.

    // Positions
    public Vector2DInt positionOnTheMap;

    // Collisions
    public boolean isColliding = false;
    public Rectangle solidArea;       // Indicates the solid area of the entity, under collision.

}

