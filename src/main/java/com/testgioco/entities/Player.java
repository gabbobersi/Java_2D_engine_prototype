package com.testgioco.entities;
import com.testgioco.base_classes.Race;

public class Player extends Race {
    public Player(int x, int y, String name, String type, double life, int speed) {
        super(x, y, name, type, life, speed);
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