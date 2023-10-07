package com.testgioco;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double magnitude = getMagnitude();
        x = x == 0 ? 0 : x / magnitude;
        y = y == 0 ? 0 : y / magnitude;
    }

    public void multiply(int speed){
        x *= speed;
        y *= speed;
    }
}
