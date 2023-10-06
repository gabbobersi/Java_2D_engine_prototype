package com.testgioco.entities;

import com.testgioco.Cell;
import com.testgioco.InputHandler;
import com.testgioco.base_classes.Entity;
import com.testgioco.exceptions.InvalidResourcesException;
import com.testgioco.ui_elements.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    InputHandler keyH;
    int speed = 5;
    Cell cell;
    public Player(InputHandler keyH){
        this.keyH = keyH;
        this.x = 100;
        this.y = 100;

         cell = new Cell();

        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("assets/player/t2.png"));
            down1 = ImageIO.read(new File("assets/player/t1.png"));
            left1 = ImageIO.read(new File("assets/player/t2.png"));
            right1 = ImageIO.read(new File("assets/player/t1.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        direction = "down";         // Default direction

        if (keyH.upPressed){
            direction = "up";
            this.y -= speed;
        }
        if (keyH.downPressed){
            direction = "down";
            this.y += speed;
        }
        if (keyH.rightPressed){
            direction = "right";
            this.x += speed;
        }
        if (keyH.leftPressed){
            direction = "left";
            this.x -= speed;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = switch (direction) {
            case "up" -> up1;
            case "down" -> down1;
            case "left" -> left1;
            case "right" -> right1;
            default -> null;
        };
        System.out.println("La direzione è " + direction);
        g2.drawImage(image, x, y, this.cell.size, this.cell.size, null);
    }
}