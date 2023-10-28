package com.testgioco.core;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){return x;}
    public void setX(double value){x = value;}

    public double getY(){
        return y;
    }
    public void setY(double value){y = value;}

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double magnitude = getMagnitude();
        x = x == 0 ? 0 : x / magnitude;
        y = y == 0 ? 0 : y / magnitude;
    }

    public void multiply(double speed){
        x *= speed;
        y *= speed;
    }
}
