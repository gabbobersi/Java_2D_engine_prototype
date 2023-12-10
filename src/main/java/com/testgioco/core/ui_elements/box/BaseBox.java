package com.testgioco.core.ui_elements.box;

import com.testgioco.core.interfaces.ui.VisibleUI;
import com.testgioco.utilities.Vector2DInt;

import java.awt.geom.Rectangle2D;

public class BaseBox implements VisibleUI {
    protected Rectangle2D.Double box = new Rectangle2D.Double();
    protected Rectangle2D.Double boxBorders = new Rectangle2D.Double();
    protected Vector2DInt positionOnTheScreen;
    protected int width, height;
    protected int bordThickness;
    protected RenderingAlignment renderingAlign = BoxColor.RenderingAlignment.DEFAULT;
    protected boolean isVisible = true;

    public enum RenderingAlignment {
        DEFAULT,    // The ButtonLabel will be rendered by the usual x, y coordinates, from the left top corner.
        CENTER      // The ButtonLabel will be rendered by the usual x, y coordinates, from center of width/height.
    }

    public BaseBox(Vector2DInt positionOnTheScreen, int width, int height, int bordThickness){
        this.positionOnTheScreen = positionOnTheScreen;
        this.width = width;
        this.height = height;
        this.bordThickness = bordThickness;
    }

    protected void renderTopLeft(){
        box.setRect(positionOnTheScreen.getX(), positionOnTheScreen.getY(), width, height);
        int midThickness = (int)Math.round(((double)bordThickness / 2));
        boxBorders.setRect(positionOnTheScreen.getX() - midThickness, positionOnTheScreen.getY() - midThickness,width + bordThickness,
                height + bordThickness);
    }

    protected void renderCenter(){
        Vector2DInt centerCoordinates = getBoxCenter();
        box.setRect(centerCoordinates.getX(), centerCoordinates.getY(), width,height);

        int midWidth_boxBorders = Math.round((float)(width+bordThickness)/2);
        int midHeight_boxBorders = Math.round((float)(height+bordThickness)/2);
        int bb_width = positionOnTheScreen.getX() + midWidth_boxBorders-bordThickness;
        int bb_height = positionOnTheScreen.getY() + midHeight_boxBorders-bordThickness;
        boxBorders.setRect(bb_width,bb_height,width + bordThickness,height + bordThickness);
    }

    /**
     * Returns the center of the box.
     * */
    protected Vector2DInt getBoxCenter(){
        int midWidth_box = Math.round((float)(width/2));
        int midHeight_box = Math.round((float)(height/2));
        return new Vector2DInt(positionOnTheScreen.getX()+midWidth_box,positionOnTheScreen.getY()+midHeight_box);
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public Vector2DInt getPositionOnTheScreen() {
        return positionOnTheScreen;
    }

    public int getX(){return positionOnTheScreen.getX();}
    public int getY() {return positionOnTheScreen.getY();}
    public void setX(int x){positionOnTheScreen.setX(x);}
    public void setY(int y){positionOnTheScreen.setY(y);}

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public void setThickness(int bordThickness) {
        this.bordThickness = bordThickness;
    }
}
