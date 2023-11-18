package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box extends JPanel{
    Rectangle2D.Double box = new Rectangle2D.Double();
    Rectangle2D.Double boxBorders = new Rectangle2D.Double();
    private Vector2DInt vector;
    private int width, height;
    private int bordThickness;
    private Color boxColor;
    private RenderingAlignment renderingAlign = RenderingAlignment.DEFAULT;

    public enum RenderingAlignment {
        DEFAULT,    // The button will be rendered by the usual x, y coordinates, from the left top corner.
        CENTER      // The button will be rendered by the usual x, y coordinates, from center of width/height.
    }

    public Box(Vector2DInt vector, int width, int height, int bordThickness, Color boxColor){
        this.vector = vector;
        this.width = width;
        this.height = height;
        this.bordThickness = bordThickness;
        this.boxColor = boxColor;
        setVisible(true);
    }

    /**
     * Check if mouse has been pressed inside box's boundaries.
     * */
    public boolean hasBeenPressed(){
        boolean okWidth =
                Singletons.mouseH.xPressed >= vector.getX() && Singletons.mouseH.xPressed <= vector.getX() + width;
        boolean okHeight =
                Singletons.mouseH.yPressed > vector.getY() && Singletons.mouseH.yPressed < vector.getY() + height;
        boolean isReleased = Singletons.mouseH.released;

        boolean condition = okWidth && okHeight && !isReleased;
        return condition;
    }

    /**
     * Check if mouse has been clicked inside box's boundaries.
     * */
    public boolean hasBeenClicked(){
        boolean okWidth =
                Singletons.mouseH.xClick >= vector.getX() && Singletons.mouseH.xClick <= vector.getX() + width;
        boolean okHeight =
                Singletons.mouseH.yClick > vector.getY() && Singletons.mouseH.yClick < vector.getY() + height;
        boolean isReleased = Singletons.mouseH.released;
        boolean condition = okWidth && okHeight && !isReleased;

        System.out.println("Width " + okWidth);
        System.out.println("Height " + okHeight);
        System.out.println("Rilasciato? " + isReleased);

        return condition;
    }

    /**
     * Check if mouse is over the box's boundaries.
     * */
    public boolean hasMouseOver(){
        return (Singletons.mouseMotionH.x >= vector.getX() && Singletons.mouseMotionH.x <= vector.getX() + width)
                && (Singletons.mouseMotionH.y > vector.getY() && Singletons.mouseMotionH.y < vector.getY() + height);
    }

    public void draw(Graphics2D g2) {
        switch (renderingAlign){
            case DEFAULT -> renderTopLeft();
            case CENTER -> renderCenter();
        }

        g2.setColor(Color.BLACK);
        g2.fill(boxBorders);
        g2.setColor(boxColor);
        g2.fill(box);
    }

    private void renderTopLeft(){
        box.setRect(vector.getX(), vector.getY(), width, height);
        int midThickness = (int)Math.round(((double)bordThickness / 2));
        boxBorders.setRect(vector.getX() - midThickness, vector.getY() - midThickness,width + bordThickness,
            height + bordThickness);
    }

    private void renderCenter(){
        Vector2DInt centerCoordinates = getBoxCenter();
        box.setRect(centerCoordinates.getX(), centerCoordinates.getY(), width,height);

        int midWidth_boxBorders = Math.round((float)(width+bordThickness)/2);
        int midHeight_boxBorders = Math.round((float)(height+bordThickness)/2);
        int bb_width = vector.getX() + midWidth_boxBorders-bordThickness;
        int bb_height = vector.getY() + midHeight_boxBorders-bordThickness;
        boxBorders.setRect(bb_width,bb_height,width + bordThickness,height + bordThickness);
    }

    /**
     * Returns a new Vector2DInt, with the center of the box as new coordinates.
     * */
    public Vector2DInt getBoxCenter(){
        int midWidth_box = Math.round((float)(getWidth()/2));
        int midHeight_box = Math.round((float)(getHeight()/2));
        return new Vector2DInt(vector.getX()+midWidth_box,vector.getY()+midHeight_box);
    }

    public void setX(int x){vector.setX(x);}
    public void setY(int y){vector.setY(y);}
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getX(){return vector.getX();}
    public int getY() {return vector.getY();}
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getThickness() {
        return bordThickness;
    }
    public void setThickness(int bordThickness) {
        this.bordThickness = bordThickness;
    }
    public Color getBoxColor() {
        return boxColor;
    }
    public void setColor(Color boxColor) {
        this.boxColor = boxColor;
    }

    public RenderingAlignment getRenderingAlign() {
        return renderingAlign;
    }

    public void setRenderingAlign(RenderingAlignment renderingAlign) {
        this.renderingAlign = renderingAlign;
    }
}
