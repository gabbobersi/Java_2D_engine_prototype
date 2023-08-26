package com.testgioco.entity;

import com.testgioco.base_classes.Entity;

public class Elf extends Entity {
    public Elf(){
        SetDefaultValues();
    }
    public Elf(String name, String type, int life, int speed, int x, int y){
        this.name = name;
        this.type = type;
        this.life = life;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void SetDefaultValues(){
        this.name = "Galadriel";
        this.type = "Elf";
        this.life = 60;     // .
        this.speed = 20;
        this.x = 50;
        this.y = 50;
    }
}
