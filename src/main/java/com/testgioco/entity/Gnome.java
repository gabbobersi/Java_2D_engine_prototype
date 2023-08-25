package com.testgioco.entity;

import com.testgioco.base_classes.Entity;

public class Gnome extends Entity {
    // Ho creato due costruttori, in modo che in uno i parametri siano default, nell'altro siano specificabili a codice.
    public Gnome(){
        SetDefaultValues();
    }
    public Gnome(String name, String type, int life, int speed, int x, int y){
        this.name = name;
        this.type = type;
        this.life = life;
        this.speed = speed;
        this.x = x;
        this.y = y;
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
