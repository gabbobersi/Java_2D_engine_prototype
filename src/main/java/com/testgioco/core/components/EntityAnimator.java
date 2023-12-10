package com.testgioco.core.components;

import com.testgioco.core.Direction;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class EntityAnimator {
    public enum AnimationType {
        IDLE,               // Default animation.
        UP1, UP2,
        DOWN1, DOWN2,
        LEFT1, LEFT2,
        RIGHT1, RIGHT2
    }

    private final HashMap<AnimationType, BufferedImage> sprites;
    private final long animationInterval;
    private long lastAnimationTime = System.nanoTime();

    private int spriteNumber = 1;

    public EntityAnimator(HashMap<AnimationType, BufferedImage> sprites, long animationInterval){
        this.sprites = sprites;
        this.animationInterval = animationInterval;
    }

    /**
     * Updates the sprite number, based on the animation interval.
     * */
    private void updateSpriteNumber(){
        long currentTime = System.nanoTime();
        long elapsedTime = currentTime - lastAnimationTime;
        if (elapsedTime >= animationInterval) {
            // Change animation sprite.
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else {
                spriteNumber = 1;
            }
            lastAnimationTime = currentTime;
        }
    }

    private void resetAnimation(){
        spriteNumber = 1;
    }

    public void updateAnimation(boolean isMoving){
        if (isMoving) {
            updateSpriteNumber();
        } else {
            // If the player does not move, he will remain standing.
            resetAnimation();
        }
    }

    /**
     * Returns the sprite based on the direction and the sprite number.
     * */
    public BufferedImage getSprite(Direction direction, int spriteNumber){
        BufferedImage image = sprites.get(AnimationType.IDLE);
        switch (direction){
            case UP -> {
                if (spriteNumber == 1){
                    image = sprites.get(AnimationType.UP1);
                } else if (spriteNumber == 2){
                    image = sprites.get(AnimationType.UP2);
                }
            }
            case DOWN -> {
                if (spriteNumber == 1){
                    image = sprites.get(AnimationType.DOWN1);
                } else if (spriteNumber == 2){
                    image = sprites.get(AnimationType.DOWN2);
                }
            }
            case LEFT -> {
                if (spriteNumber == 1){
                    image = sprites.get(AnimationType.LEFT1);
                } else if (spriteNumber == 2){
                    image = sprites.get(AnimationType.LEFT2);
                }
            }
            case RIGHT -> {
                if (spriteNumber == 1){
                    image = sprites.get(AnimationType.RIGHT1);
                } else if (spriteNumber == 2){
                    image = sprites.get(AnimationType.RIGHT2);
                }
            }
            default -> image = sprites.get(AnimationType.IDLE);
        }
        return image;
    }

    /**
     * Returns the active sprite (calculated by time passed) based on direction.
     * */
    public BufferedImage getActiveSprite(Direction direction){
        BufferedImage image = sprites.get(AnimationType.IDLE);

        switch (direction) {
            case UP:
                if (spriteNumber == 1) {
                    image = sprites.get(AnimationType.UP1);
                } else if (spriteNumber == 2) {
                    image = sprites.get(AnimationType.UP2);
                }
                break;
            case DOWN:
                if (spriteNumber == 1) {
                    image = sprites.get(AnimationType.DOWN1);
                } else if (spriteNumber == 2) {
                    image = sprites.get(AnimationType.DOWN2);
                }
                break;
            case LEFT:
                if (spriteNumber == 1) {
                    image = sprites.get(AnimationType.LEFT1);
                } else if (spriteNumber == 2) {
                    image = sprites.get(AnimationType.LEFT2);
                }
                break;
            case RIGHT:
                if (spriteNumber == 1) {
                    image = sprites.get(AnimationType.RIGHT1);
                } else if (spriteNumber == 2) {
                    image = sprites.get(AnimationType.RIGHT2);
                }
                break;
            default:
                image = sprites.get(AnimationType.IDLE);
                break;
        }
        return image;
    }

}
