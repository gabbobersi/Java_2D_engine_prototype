package com.testgioco.entities;

import com.testgioco.core.Cell;
import com.testgioco.core.InputHandler;
import com.testgioco.core.Vector2D;
import com.testgioco.entities.base_classes.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    public InputHandler keyH;

    private double speed;
    private long lastAnimationTime;
    private final Cell cell = new Cell();
    private Vector2D vector;

    public Player(){
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        direction = "down";         // Default direction
        vector = new Vector2D(0, 0);
        lastAnimationTime = System.nanoTime();
        x = 10;
        y = 10;
        speed = 4;
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

    public void getInput(){
        vector.setX(0);
        vector.setY(0);

        // If any key is being pressed...
        if (keyH.anyKeyPressed){
            if (keyH.upPressed){
                direction = "up";
                vector.setY(-1);
            }
            if (keyH.downPressed){
                direction = "down";
                vector.setY(1);
            }
            if (keyH.leftPressed){
                direction = "left";
                vector.setX(-1);
            }
            if (keyH.rightPressed){
                direction = "right";
                vector.setX(1);
            }
            animate(direction);
        } else {
            direction = "down";     // Default direction, even if no key is pressed
        }
    }

    private void animate(String newDirection){
        if (!newDirection.equals(direction)) {
            // Resetta l'animazione se la direzione è cambiata.
            spriteNumber = 1;
            direction = newDirection;
        } else {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastAnimationTime;
            long animationInterval = 100_000_000;
            if (elapsedTime >= animationInterval) {
                // Cambia l'immagine dell'animazione.
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else {
                    spriteNumber = 1;
                }
                lastAnimationTime = currentTime;
            }
        }
    }

    public void update(){
        vector.normalize();
        vector.multiply(speed);
        x += vector.getX();
        y += vector.getY();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = up1;

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

        g2.drawImage(image, (int) Math.round(x), (int) Math.round(y), this.cell.width, this.cell.height, null);
    }
}