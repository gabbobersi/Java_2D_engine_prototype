package com.testgioco.core.ui_elements;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box extends JPanel{
    Rectangle2D.Double box = new Rectangle2D.Double();
    Rectangle2D.Double boxBorders = new Rectangle2D.Double();
    private int x,y;
    private int width,height;
    private int thickness;
    private Color boxColor;


    public Box(){
        setVisible(true);
    }


    public void draw(Graphics2D g2) {
        update();
        g2.setColor(Color.BLACK);
        g2.fill(boxBorders);
        g2.setColor(boxColor);
        g2.fill(box);
    }
    private void update(){
        int midWidth_box = Math.round((float)(width/2));
        int midHeight_box = Math.round((float)(height/2));
        box.setRect(x+midWidth_box,y+midHeight_box,width,height);

        int midWidth_boxBorders = Math.round((float)(width+thickness)/2);
        int midHeight_boxBorders = Math.round((float)(height+thickness)/2);
        int bb_width = x+midWidth_boxBorders-thickness;
        int bb_height = y+midHeight_boxBorders-thickness;
        boxBorders.setRect(bb_width,bb_height,width + thickness,height + thickness);
    }
    public Rectangle2D.Double getComponent(){
        return box;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
   public int getX(){
        return x;
   }
   public int getY(){
        return y;
   }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getThickness() {
        return thickness;
    }
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
    public Color getBoxColor() {
        return boxColor;
    }
    public void setBoxColor(Color boxColor) {
        this.boxColor = boxColor;
    }
}
