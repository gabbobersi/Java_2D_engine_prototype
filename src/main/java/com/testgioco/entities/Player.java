package com.testgioco.entities;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.Vector2D;
import com.testgioco.core.interfaces.entity.Animatable;
import com.testgioco.core.interfaces.entity.SolidMovableEntity;
import com.testgioco.entities.base_classes.Entity;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Player extends Entity implements SolidMovableEntity, Animatable {
    private Vector2D vector;
    private final AxisController axisController = new AxisController();
    private int speed = 4;
    private final EntityAnimator animator;
    private Direction direction = Direction.DOWN;

    // Player rendering position on the screen.
    public Vector2DInt positionOnScreen;

    public Player(){
        setDefaultValues();
        getPlayerImage();

        HashMap<EntityAnimator.AnimationType, BufferedImage> sprites = new HashMap<>();
        // This will be the default sprite.
        sprites.put(EntityAnimator.AnimationType.IDLE, down1);

        sprites.put(EntityAnimator.AnimationType.UP1, up1);
        sprites.put(EntityAnimator.AnimationType.UP2, up2);
        sprites.put(EntityAnimator.AnimationType.DOWN1, down1);
        sprites.put(EntityAnimator.AnimationType.DOWN2, down2);
        sprites.put(EntityAnimator.AnimationType.LEFT1, left1);
        sprites.put(EntityAnimator.AnimationType.LEFT2, left2);
        sprites.put(EntityAnimator.AnimationType.RIGHT1, right1);
        sprites.put(EntityAnimator.AnimationType.RIGHT2, right2);
        animator = new EntityAnimator(sprites, 100_000_000L);
    }

    public void setDefaultValues(){
        vector = new Vector2D(0, 0);

        // Starting position
        positionOnTheMap = new Vector2DInt(150, 100);

        // Position on the screen
        int x = GameSettings.screenWidth / 2 - (Constants.cellWidth / 2);
        int y = GameSettings.screenHeight / 2 - (Constants.cellHeight / 2);
        positionOnScreen = new Vector2DInt(x, y);

        // Collision
        solidArea = new Rectangle(8, 16, Constants.cellWidth - 14, Constants.cellHeight - 14);
        isColliding = false;
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("assets/player/player_up_1.png"));
            up2 = ImageIO.read(new File("assets/player/player_up_2.png"));

            down1 = ImageIO.read(new File("assets/player/player_down_1.png"));
            down2 = ImageIO.read(new File("assets/player/player_down_2.png"));

            left1 = ImageIO.read(new File("assets/player/player_left_1.png"));
            left2 = ImageIO.read(new File("assets/player/player_left_2.png"));

            right1 = ImageIO.read(new File("assets/player/player_right_1.png"));
            right2 = ImageIO.read(new File("assets/player/player_right_2.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Gets input from the keyboard.
     * */
    private void getInput() {
        vector.setX(0);
        vector.setY(0);
        if (axisController.anyAxisIsActive() && !isColliding) {
            Direction h = axisController.getHorizontalDirection();
            Direction v = axisController.getVerticalDirection();
            // Left, right
            if (h != null) {
                switch (h) {
                    case LEFT -> vector.setX(-1);
                    case RIGHT -> vector.setX(1);
                }
            }
            // Up, down
            if (v != null) {
                switch (v) {
                    case UP -> vector.setY(-1);
                    case DOWN -> vector.setY(1);
                }
            }
            if (vector.getX() != 0 || vector.getY() != 0) {
                direction = Direction.getDirection(vector);
                if (direction == Direction.DOWN_LEFT || direction == Direction.UP_LEFT) {
                    direction = Direction.LEFT;
                } else if (direction == Direction.DOWN_RIGHT || direction == Direction.UP_RIGHT) {
                    direction = Direction.RIGHT;
                }
            }
        }
    }

    public boolean isMoving(){
        return vector.getX() != 0 || vector.getY() != 0;
    }

    /**
     * Updates player's position on the map.
     * */
    public void update(){
        getInput();
        animator.updateAnimation(isMoving());

        vector.normalize();
        vector.multiply(speed);
        int x = positionOnTheMap.getX() + (int) Math.round(vector.getX());
        int y = positionOnTheMap.getY() + (int) Math.round(vector.getY());

        positionOnTheMap.setX(x);
        positionOnTheMap.setY(y);
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = animator.getActiveSprite(direction);

        g2.drawImage(image, Math.round(positionOnScreen.getX()), Math.round(positionOnScreen.getY()),
                Constants.cellWidth, Constants.cellHeight, null);
    }

    @Override
    public void onCollision() {
        System.out.println(this.getClass().getName() + " collided.");
    }

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setCollision(boolean isColliding) {
        this.isColliding = isColliding;
    }

    @Override
    public Vector2DInt getPositionOnTheMap() {
        return positionOnTheMap;
    }

    @Override
    public Direction getVerticalDirection() {
        return axisController.getVerticalDirection();
    }

    @Override
    public Direction getHorizontalDirection() {
        return axisController.getHorizontalDirection();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}