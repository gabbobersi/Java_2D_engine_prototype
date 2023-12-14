package com.testgioco.entities;

import com.testgioco.core.AxisController;
import com.testgioco.core.Direction;
import com.testgioco.core.components.EntityAnimator;
import com.testgioco.core.interfaces.entity.SolidVisibleEntity;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.utilities.Vector2D;
import com.testgioco.entities.base_classes.Entity;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Player extends Entity implements SolidVisibleEntity {
    private Vector2D vector;
    private final AxisController axisController = new AxisController();
    private int speed = 4;
    private final EntityAnimator animator;
    private Direction direction = Direction.DOWN;

    private boolean isVisible = true;
    private boolean canChangeVisibility = true;

    Timer changeVisibilityTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            canChangeVisibility = true;
        }
    });

    public Player(){
        changeVisibilityTimer.setRepeats(false);
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
        positionOnTheScreen = new Vector2D(x, y);

        // Collision
        int solidHeight = Constants.cellHeight - 20;
        int solidWidth = Constants.cellWidth - 20;
        solidArea = new Rectangle(
                (Constants.cellWidth - solidWidth) / 2,
                Constants.cellHeight - solidHeight,
                solidWidth,
                solidHeight
        );
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

        // Getting left, right
        if (!isCollidingHorizontally){
            Direction h = axisController.getHorizontalDirection();
            if (h != null) {
                switch (h) {
                    case LEFT -> vector.setX(-1);
                    case RIGHT -> vector.setX(1);
                }
            }
        }

        // Getting up, down
        if (!isCollidingVertically) {
            Direction v = axisController.getVerticalDirection();
            if (v != null) {
                switch (v) {
                    case UP -> vector.setY(-1);
                    case DOWN -> vector.setY(1);
                }
            }
        }
    }

    /**
     * Updates player's position on the map.
     * */
    public void update(){
        getInput();
        animator.updateAnimation(isMoving());
        checkDiagonalDirection();

        vector.normalize();
        vector.multiply(speed);
        int x = positionOnTheMap.getX() + (int) Math.round(vector.getX());
        int y = positionOnTheMap.getY() + (int) Math.round(vector.getY());

        positionOnTheMap.setX(x);
        positionOnTheMap.setY(y);
    }

    private void checkDiagonalDirection(){
        direction = Direction.getDirection(vector);

        // In case no direction is set, we use a default one.
        if (direction == Direction.IDLE){
            direction = Direction.DOWN;
        }

        if (direction == Direction.DOWN_LEFT){
            if (!isCollidingVertically){
                direction = Direction.DOWN;
            }
            if (!isCollidingHorizontally){
                direction = Direction.LEFT;
            }
        }

        if (direction == Direction.DOWN_RIGHT){
            if (!isCollidingVertically){
                direction = Direction.DOWN;
            }
            if (!isCollidingHorizontally){
                direction = Direction.RIGHT;
            }
        }

        if (direction == Direction.UP_LEFT){
            if (!isCollidingVertically){
                direction = Direction.UP;
            }
            if (!isCollidingHorizontally){
                direction = Direction.LEFT;
            }
        }

        if (direction == Direction.UP_RIGHT){
            if (!isCollidingVertically){
                direction = Direction.UP;
            }
            if (!isCollidingHorizontally){
                direction = Direction.RIGHT;
            }
        }

    }
    public void draw(Graphics2D g2) {
        if (!isVisible){
            return;
        }
        BufferedImage image = animator.getActiveSprite(direction);

        int x = (int)Math.round(positionOnTheScreen.getX());
        int y = (int)Math.round(positionOnTheScreen.getY());
        g2.drawImage(image, x, y, Constants.cellWidth, Constants.cellHeight, null);
    }

    @Override
    public void onCollision() {
        if (isCollidingVertically){
            System.out.println("Vertical collision");
        }
        if (isCollidingHorizontally){
            System.out.println("Horizontal collision");
        }
    }

    @Override
    public boolean isColliding() {
        return isCollidingVertically || isCollidingHorizontally;
    }

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public Vector2DInt getSolidAreaPositionOnTheScreen() {
        Vector2DInt pos = new Vector2DInt(
                (int)Math.round(positionOnTheScreen.getX()) + solidArea.x,
                (int)Math.round(positionOnTheScreen.getY()) + solidArea.y
        );
        return pos;
    }

    @Override
    public void setVerticalCollision(boolean isColliding) {
        this.isCollidingVertically = isColliding;
    }

    @Override
    public void setHorizontalCollision(boolean isColliding) {
        this.isCollidingHorizontally = isColliding;
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

    @Override
    public boolean isMoving(){
        return vector.getX() != 0 || vector.getY() != 0;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        if (canChangeVisibility){
            this.isVisible = isVisible;
        }
        canChangeVisibility = false;
        changeVisibilityTimer.start();
    }

    @Override
    public Vector2D getPositionOnTheScreen() {
        return positionOnTheScreen;
    }
}