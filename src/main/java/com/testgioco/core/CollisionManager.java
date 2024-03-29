package com.testgioco.core;

import com.testgioco.core.interfaces.base.Collidable;
import com.testgioco.core.interfaces.entity.SolidEntity;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.tile.TileManager;
import com.testgioco.utilities.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CollisionManager {
    private final TileManager tileManager;
    private final SolidEntity entity;

    private final Rectangle solidArea;
    private final Vector2DInt positionOnTheMap;
    private final int speed;

    public CollisionManager(TileManager tileManager, SolidEntity entity){
        this.tileManager = tileManager;
        this.entity = entity;

        solidArea = entity.getSolidArea();
        positionOnTheMap = entity.getPositionOnTheMap();
        speed = entity.getSpeed();
    }

    public void checkCollision(){
        // Position of the entity's solid area, in the map.
        int entityLeft = positionOnTheMap.getX() + solidArea.x;
        int entityRight = positionOnTheMap.getX() + solidArea.x + solidArea.width;
        int entityUp = positionOnTheMap.getY() + solidArea.y;
        int entityDown = positionOnTheMap.getY() + solidArea.y + solidArea.height;

        // Tile's coordinates relative to the entity's solid area position.
        int entityLeftCell = entityLeft / Constants.cellWidth;
        int entityRightCell = entityRight / Constants.cellWidth;
        int entityUpCell = entityUp / Constants.cellHeight;
        int entityDownCell = entityDown / Constants.cellHeight;

        // We check collision, based on direction, over the near two tiles.
        boolean tile1Collision = false;
        boolean tile2Collision = false;
        boolean isCollidingVertically = false;
        boolean isCollidingHorizontally = false;

        Direction verticalDirection = entity.getVerticalDirection();
        Direction horizontalDirection = entity.getHorizontalDirection();

        // Entity is not moving.
        if (verticalDirection == null && horizontalDirection == null){
            entity.setVerticalCollision(false);
            entity.setHorizontalCollision(false);
            return;
        }

        ArrayList<Vector2DInt> tilesToHighlight = new ArrayList<>();

        if (verticalDirection != null){
            if (Objects.equals(verticalDirection, Direction.UP)) {
                entityUpCell = (entityUp - speed) / Constants.cellHeight;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityUpCell, entityRightCell).hasCollision();

                tilesToHighlight.add(new Vector2DInt(entityUpCell, entityLeftCell));
                tilesToHighlight.add(new Vector2DInt(entityUpCell, entityRightCell));
            } else if (Objects.equals(verticalDirection, Direction.DOWN)) {
                entityDownCell = (entityDown + speed) / Constants.cellHeight;
                tile1Collision = tileManager.getTileByCoordinates(entityDownCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityRightCell).hasCollision();

                tilesToHighlight.add(new Vector2DInt(entityDownCell, entityLeftCell));
                tilesToHighlight.add(new Vector2DInt(entityDownCell, entityRightCell));
            }
            isCollidingVertically = tile1Collision || tile2Collision;
        }

        if (horizontalDirection != null){
            if (Objects.equals(horizontalDirection, Direction.LEFT)) {
                entityLeftCell = (entityLeft - speed) / Constants.cellWidth;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityLeftCell).hasCollision();

                tilesToHighlight.add(new Vector2DInt(entityUpCell, entityLeftCell));
                tilesToHighlight.add(new Vector2DInt(entityDownCell, entityLeftCell));
            } else if (Objects.equals(horizontalDirection, Direction.RIGHT)) {
                entityRightCell = (entityRight + speed) / Constants.cellWidth;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityRightCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityRightCell).hasCollision();

                tilesToHighlight.add(new Vector2DInt(entityUpCell, entityRightCell));
                tilesToHighlight.add(new Vector2DInt(entityDownCell, entityRightCell));
            }
            isCollidingHorizontally = tile1Collision || tile2Collision;
        }

        tileManager.highlightTiles(tilesToHighlight);

        entity.setVerticalCollision(isCollidingVertically);
        entity.setHorizontalCollision(isCollidingHorizontally);
        if (entity.isColliding()){
            entity.onCollision();
        }
    }

    public void drawCollision(Graphics2D g2, Collidable entity){
        g2.setColor(Color.RED);
        g2.drawRect(
            entity.getSolidAreaPositionOnTheScreen().getX(),
            entity.getSolidAreaPositionOnTheScreen().getY(),
            entity.getSolidArea().width,
            entity.getSolidArea().height
        );
    }
}