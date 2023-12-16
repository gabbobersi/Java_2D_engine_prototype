package com.testgioco.utilities;

import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage originalImage;
    private BufferedImage currentImage;

    public Image(BufferedImage image){
        originalImage = image;
        currentImage = copyImage(originalImage);
    }

    /**
     * Copy an image pixel by pixel.
     * */
    private BufferedImage copyImage(BufferedImage source) {
        BufferedImage copy = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

        for (int i = 0; i < source.getWidth(); i++) {
            for (int j = 0; j < source.getHeight(); j++) {
                int color = source.getRGB(i, j);
                copy.setRGB(i, j, color);
            }
        }

        return copy;
    }

    /**
     * Brighten the image by a certain amount of pixels.
     * */
    public void brightImage(int pixelAmount){
        for (int i = 0; i < currentImage.getWidth(); i++) {
            for (int j = 0; j < currentImage.getHeight(); j++) {
                int color = currentImage.getRGB(i, j);
                currentImage.setRGB(i, j, color + pixelAmount);
            }
        }
    }

    /**
     * Reset the image to its original state.
     * */
    public void resetImage(){
        currentImage = copyImage(originalImage);
    }

    public BufferedImage getImage(){
        return currentImage;
    }

    public void setImage(BufferedImage image){
        this.originalImage = copyImage(image);
        this.currentImage = copyImage(image);
    }
}
