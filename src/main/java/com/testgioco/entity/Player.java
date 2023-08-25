package com.testgioco.entity;
import com.testgioco.base_classes.Entity;

public class Player extends Entity {
    public Player() {
        // Impostazione dei valori di default
        this.name = "Gnome";
        this.type = "Giocatore";
        this.x = 0;
        this.y = 0;
        this.speed = 10;
        this.life = 100.0;

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