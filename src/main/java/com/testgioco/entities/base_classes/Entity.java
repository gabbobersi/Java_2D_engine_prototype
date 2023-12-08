package com.testgioco.entities.base_classes;

import com.testgioco.core.Vector2DInt;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.security.PublicKey;
import java.util.HashMap;

public class Entity {
    // Sprites
    protected BufferedImage up1, up2;
    protected BufferedImage down1, down2;
    protected BufferedImage left1, left2;
    protected BufferedImage right1, right2;

    // Positions
    public Vector2DInt positionOnTheMap;

    // Collisions
    public boolean isColliding = false;
    public Rectangle solidArea;       // Indicates the solid area of the entity, under collision.
}

