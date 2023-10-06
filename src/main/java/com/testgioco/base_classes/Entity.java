package com.testgioco.base_classes;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;                    // Coordinates
    public BufferedImage testImage;     // Test only
    public BufferedImage up1, up2;
    public BufferedImage down1, down2;
    public BufferedImage left1, left2;
    public BufferedImage right1, right2;
    public String direction;            // Sprite direction.

    public int spriteCounter = 0;       // Number of drawed animations.
    public int spriteNumber = 1;        // Number of the actual animation.
}
