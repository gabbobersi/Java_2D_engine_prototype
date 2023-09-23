package com.testgioco.base_classes;

public class Race extends Entity {
    public String name;
    public String type;
    public double life;
    public int speed;

    public Race(int x, int y, String name, String type, double life, int speed) {
        super(x, y);
        this.name = name;
        this.type = type;
        this.life = life;
        this.speed = speed;
    }

}
