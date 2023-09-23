package com.testgioco.entities;

import com.testgioco.base_classes.Race;

public class Orc extends Race {
    public Orc( int x, int y, String name, String type, double life, int speed){
        super(x, y, name, type, life, speed);
    }

    public void SetDefaultValues(){
        this.name = "Bolg";
        this.type = "Orc";
        this.life = 50;     // .
        this.speed = 15;
        this.x = 50;
        this.y = 50;
    }
}