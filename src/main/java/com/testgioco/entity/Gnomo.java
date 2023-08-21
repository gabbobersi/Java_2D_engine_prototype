package com.testgioco.entity;

public class Gnomo extends Entity{
    public Gnomo(){
        SetDefaultValues();
    }
    public void SetDefaultValues(){
        this.name = "Piccolo di Trivia";
        this.type = "Gnomo";
        this.life = 40;     // E' facile da uccidere. Fa danno in gruppo.
        this.speed = 10;
        this.x = 50;
        this.y = 50;
    }
}
