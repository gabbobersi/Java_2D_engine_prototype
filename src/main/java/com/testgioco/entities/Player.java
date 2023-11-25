package com.testgioco.entities;

import com.testgioco.core.Cell;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.Vector2D;
import com.testgioco.entities.base_classes.Entity;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    private InputHandler keyH;
    private GameSettings settings = new GameSettings();

    private double speed;
    private long lastAnimationTime;
    private final Cell cell = new Cell();
    private Vector2D vector;

    // Player rendering position on the screen.
    public Vector2DInt positionOnScreen;

    public Player(InputHandler keyH){
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        direction = "down";         // Default direction
        vector = new Vector2D(0, 0);
        lastAnimationTime = System.nanoTime();
        speed = 4;

        // Starting position
        positionOnTheMap = new Vector2DInt(150, 100);

        // Position on the screen
        int x = settings.screenWidth / 2 - (cell.width / 2);
        int y = settings.screenHeight / 2 - (cell.height / 2);
        positionOnScreen = new Vector2DInt(x, y);
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
            animate(direction, true);
        } else {
            animate(direction, false);
        }
    }

    private void animate(String newDirection, boolean isMoving){
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
        // If the player does not move, he will remain standing.
        if (!isMoving){
            spriteNumber = 1;
        }
    }

    public void update(){
        vector.normalize();
        vector.multiply(speed);

        int x = positionOnTheMap.getX() + (int) Math.round(vector.getX());
        int y = positionOnTheMap.getY() + (int) Math.round(vector.getY());
        positionOnTheMap.setX(x);
        positionOnTheMap.setY(y);
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
        g2.drawImage(image, Math.round(positionOnScreen.getX()), Math.round(positionOnScreen.getY()), this.cell.width
                , this.cell.height, null);
    }
}