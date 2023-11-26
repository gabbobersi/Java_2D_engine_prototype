package com.testgioco.core;

import com.testgioco.core.tile.TileManager;
import com.testgioco.entities.base_classes.Entity;

public class CollisionManager {
    private final Cell cell = new Cell();
    private final TileManager tileManager;

    public CollisionManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public void checkCollision(Entity entity){
        // Position of the entity's solid area, in the map.
        int entityLeft = entity.positionOnTheMap.getX() + entity.solidArea.x;
        int entityRight = entity.positionOnTheMap.getX() + entity.solidArea.x + entity.solidArea.width;
        int entityUp = entity.positionOnTheMap.getY() + entity.solidArea.y;
        int entityDown = entity.positionOnTheMap.getY() + entity.solidArea.y + entity.solidArea.height;

        // Tile's coordinates relative to the entity's solid area position.
        int entityLeftCell = entityLeft / cell.width;
        int entityRightCell = entityRight / cell.width;
        int entityUpCell = entityUp / cell.height;
        int entityDownCell = entityDown / cell.height;

        // We check collision, based on direction, over the near two tiles.
        boolean tile1Collision;
        boolean tile2Collision;

        switch (entity.direction){
            case "up":
                entityUpCell = (entityUp - entity.speed) / cell.height;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityUpCell, entityRightCell).hasCollision();
                entity.isColliding = tile1Collision || tile2Collision;
                break;
            case "down":
                entityDownCell = (entityDown + entity.speed) / cell.height;
                tile1Collision = tileManager.getTileByCoordinates(entityDownCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityRightCell).hasCollision();
                entity.isColliding = tile1Collision || tile2Collision;
                break;
            case "left":
                entityLeftCell = (entityLeft - entity.speed) / cell.height;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityLeftCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityLeftCell).hasCollision();
                entity.isColliding = tile1Collision || tile2Collision;
                break;
            case "right":
                entityRightCell = (entityRight + entity.speed) / cell.height;
                tile1Collision = tileManager.getTileByCoordinates(entityUpCell, entityRightCell).hasCollision();
                tile2Collision = tileManager.getTileByCoordinates(entityDownCell, entityRightCell).hasCollision();
                entity.isColliding = tile1Collision || tile2Collision;
                break;
        }
    }
}