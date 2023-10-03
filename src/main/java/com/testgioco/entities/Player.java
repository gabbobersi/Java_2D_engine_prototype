package com.testgioco.entities;

import com.testgioco.Cell;
import com.testgioco.InputHandler;
import com.testgioco.base_classes.Entity;
import com.testgioco.exceptions.InvalidResourcesException;
import com.testgioco.ui_elements.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
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
        try {
            testImage = ImageIO.read(new File("assets/player/t2.png"));
            if (testImage == null){
                throw new InvalidResourcesException("Non sono riuscito a recuperare l'immagine del giocatore");
            }
        } catch (InvalidResourcesException e){
            e.printStackTrace();
            System.out.println("Sgamato");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Non sono riuscito a recuperare l'immagine del giocatore");
        }

    }

    public void update(){
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