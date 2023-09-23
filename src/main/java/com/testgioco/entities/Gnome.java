package com.testgioco.entities;

import com.testgioco.base_classes.Race;

public class Gnome extends Race {
    public Gnome(int x, int y, String name, String type, double life, int speed){
        super(x, y, name, type, life, speed);
    }

    public void SetDefaultValues(){
        this.name = "Piccolo di Trivia";
        this.type = "Gnome";
        this.life = 40;     // E' facile da uccidere. Fa danno in gruppo.
        this.speed = 10;
        this.x = 50;
        this.y = 50;
    }
}
