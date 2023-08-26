package com.testgioco.entity;
import com.testgioco.base_classes.Entity;

public class Player extends Entity {
    public Player(){
        this.setDefaultValues();
    }
    public Player(String name, String type, int x, int y, int speed, double life) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;
    }

    // Metodo per impostare i valori di default
    public void setDefaultValues() {
        this.name = "Gnome";
        this.type = "Giocatore";
        this.x = 0;
        this.y = 0;
        this.speed = 10;
        this.life = 100.0;
    }
}