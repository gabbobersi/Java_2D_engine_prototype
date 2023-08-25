package com.testgioco.entity;

import com.testgioco.base_classes.Entity;

public class Orc extends Entity {
    public Orc(){
        SetDefaultValues();
    }
    public Orc(String name, String type, int life, int speed, int x, int y){
        this.name = name;
        this.type = type;
        this.life = life;
        this.speed = speed;
        this.x = x;
        this.y = y;
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