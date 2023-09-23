package com.testgioco.entities;

import com.testgioco.base_classes.Race;

public class Elf extends Race {
    public Elf(int x, int y, String name, String type, double life, int speed){
        super(x, y, name, type, life, speed);
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
