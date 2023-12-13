package com.testgioco.core.ui_elements.button;

import com.testgioco.core.interfaces.Interactive;
import com.testgioco.core.interfaces.ui.VisibleUI;
import com.testgioco.core.ui_elements.box.BoxImage;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.utilities.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ButtonImage extends BaseButton implements VisibleUI, Interactive {
    private final BoxImage boxImage;
    private Image image;

    private boolean isBright = false;
    private boolean isClicked = false;

    public ButtonImage(Vector2DInt positionOnTheScreen, int width, int height, int bordThickness, BufferedImage image){
        super(positionOnTheScreen, width, height, bordThickness, Color.BLACK, new Font("Arial", Font.PLAIN, 12));
        this.image = new com.testgioco.utilities.Image(image);
        boxImage = new BoxImage(positionOnTheScreen, width, height, bordThickness, this.image.getImage());
    }

    public void draw(Graphics2D g2){
        if ((hasBeenClicked() || hasBeenPressed()) && !isClicked){
            isClicked = true;
            isBright = false;
            brightImage(500);
        } else if (!hasBeenClicked() && !hasBeenPressed() && isClicked){
            isClicked = false;
            isBright = false;
            resetImage();
        }

        if (hasMouseOver() && !isBright && !isClicked){
            isBright = true;
            brightImage(100);
        } else if (hasMouseOver() && isBright && !isClicked){
            isBright = false;
            resetImage();
        }
        boxImage.draw(g2);
    }

    public void setPositionOnTheScreen(Vector2DInt positionOnTheScreen){
        this.positionOnTheScreen = positionOnTheScreen;
        boxImage.setX(this.positionOnTheScreen.getX());
        boxImage.setY(this.positionOnTheScreen.getY());
    }

    private void brightImage(int pixelAmount){
        image.brightImage(pixelAmount);
        boxImage.setImage(image.getImage());
    }

    private void resetImage(){
        image.resetImage();
        boxImage.setImage(image.getImage());
    }

    public void setImage(Image image){
        this.image = image;
        boxImage.setImage(this.image.getImage());
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

    @Override
    public boolean hasBeenPressed() {
        return mouseInteractivityManager.hasBeenPressed();
    }

    @Override
    public boolean hasBeenClicked() {
        return mouseInteractivityManager.hasBeenClicked();
    }

    @Override
    public boolean hasMouseOver() {
        return mouseInteractivityManager.hasMouseOver();
    }
}
