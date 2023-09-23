package com.testgioco.entities;

import com.testgioco.base_classes.Race;

public class Human extends Race {
    public Human ( int x, int y, String name, String type, double life, int speed)
    {
        super( x, y, name, type, life, speed);
    }

    public void SetDefaultValues(){
        this.name = "Beatrix";
        this.type = "Human";
        this.life = 60;
        this.speed = 30;
        this.x = 50;
        this.y = 50;
    }
}
