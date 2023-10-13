package com.testgioco.entities;

import com.testgioco.ui_elements.Cell;
import com.testgioco.core.InputHandler;
import com.testgioco.core.Vector2D;
import com.testgioco.entities.base_classes.Entity;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    InputHandler keyH;
    int speed = 5;
    Cell cell = new Cell();
    public Player(InputHandler keyH){
        this.keyH = keyH;
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("assets/player/player_up_1.png"));
            up2 = ImageIO.read(new File("assets/player/player_up_2.png"));

            down1 = ImageIO.read(new File("assets/player/player_down_1.png"));
            down2 = ImageIO.read(new File("assets/player/player_down_2.png"));

            left1 = ImageIO.read(new File("assets/player/player_left_1.png"));
            left2 = ImageIO.read(new File("assets/player/player_left_2.png"));

            right1 = ImageIO.read(new File("assets/player/player_right_1.png"));
            right2 = ImageIO.read(new File("assets/player/player_right_2.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        direction = "down";         // Default direction (even if no key is pressed)
        int deltaX = 0;
        int deltaY = 0;

        // If any key is being pressed...
        if (keyH.anyKeyPressed){
            if (keyH.upPressed){
                direction = "up";
                deltaY--;
            }
            if (keyH.downPressed){
                direction = "down";
                deltaY++;
            }
            if (keyH.rightPressed){
                direction = "right";
                deltaX++;
            }
            if (keyH.leftPressed){
                direction = "left";
                deltaX--;
            }

            spriteCounter++;

            // Every "x" draws, I change animation.
            if (spriteCounter > 6) {
                if (spriteNumber == 1){
                    spriteNumber = 2;
                } else {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

        Vector2D vector = new Vector2D(deltaX, deltaY);
        vector.normalize();
        // System.out.println(vector.getMagnitude());
        vector.multiply(speed);
        x += vector.getX();
        y += vector.getY();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNumber == 1){
                    image = up1;
                } else if (spriteNumber == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1){
                    image = down1;
                } else if (spriteNumber == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1){
                    image = left1;
                } else if (spriteNumber == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1){
                    image = right1;
                } else if (spriteNumber == 2){
                    image = right2;
                }
                break;
        };
        g2.drawImage(image, x, y, this.cell.size, this.cell.size, null);
    }
}