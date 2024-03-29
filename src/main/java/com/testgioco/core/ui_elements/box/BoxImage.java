package com.testgioco.core.ui_elements.box;
import com.testgioco.core.interfaces.ui.VisibleUI;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BoxImage extends BaseBox implements VisibleUI {
    private BufferedImage image;

    public BoxImage(Vector2DInt positionOnTheScreen, int width, int height, int bordThickness, BufferedImage image){
        super(positionOnTheScreen, width, height, bordThickness);
        this.image = image;
    }

    public void draw(Graphics2D g2) {
        switch (renderingAlign){
            case DEFAULT -> renderTopLeft();
            case CENTER -> renderCenter();
        }

        g2.setColor(Color.BLACK);
        g2.fill(boxBorders);
        g2.drawImage(image, positionOnTheScreen.getX(), positionOnTheScreen.getY(), width, height, null);
    }

    public void setImage(BufferedImage image){
        this.image = image;
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
}
