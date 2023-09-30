package com.testgioco.entities;

import com.testgioco.Cell;
import com.testgioco.InputHandler;
import com.testgioco.base_classes.Entity;
import com.testgioco.ui_elements.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    InputHandler keyH;
    Cell cell;
    public Player(Panel gp, InputHandler keyH){
        this.keyH = keyH;
        this.x = 100;
        this.y = 100;

         cell = new Cell();

        getPlayerImage();
    }

    public void getPlayerImage(){
        try {
            System.out.println("Ciao");
            String path = "/assets/player/pippo.png";
            testImage = ImageIO.read(getClass().getResourceAsStream(path));
            System.out.println("Ciao");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        int speed = 50;
        if (keyH.upPressed){
            this.y -= speed;
        }
        if (keyH.downPressed){
            this.y += speed;
        }
        if (keyH.rightPressed){
            this.x += speed;
        }
        if (keyH.leftPressed){
            this.x -= speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(testImage, x, y, this.cell.size, this.cell.size, null);
    }
}