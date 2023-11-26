package com.testgioco.core;

import com.testgioco.core.tile.TileManager;
import com.testgioco.entities.base_classes.Entity;

public class CollisionManager {
    private static final int TILE_INDEX_OF_WALL = 1;
    private Cell cell = new Cell();
    private TileManager tileManager;

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

        int tile1;
        int tile2;

        //                System.out.println("Sopra di me, ho il tile 1: " + tileManager.getTileByIndex(tile1).getName());
        //                System.out.println("Sopra di me, ho il tile 2: " + tileManager.getTileByIndex(tile2).getName());


        switch (entity.direction){
            case "up":
                entityUpCell = (entityUp - entity.speed) / cell.height;
                tile1 = tileManager.getTileMap()[entityUpCell][entityLeftCell];
                tile2 = tileManager.getTileMap()[entityUpCell][entityRightCell];
                if (tileManager.getTileByIndex(tile1).hasCollision() || tileManager.getTileByIndex(tile2).hasCollision()){
                    entity.isColliding = true;
                } else entity.isColliding = false;
                break;
            case "down":
                entityDownCell = (entityDown + entity.speed) / cell.height;
                tile1 = tileManager.getTileMap()[entityDownCell][entityLeftCell];
                tile2 = tileManager.getTileMap()[entityDownCell][entityRightCell];
                if (tileManager.getTileByIndex(tile1).hasCollision() || tileManager.getTileByIndex(tile2).hasCollision()){
                    entity.isColliding = true;
                } else entity.isColliding = false;
                break;
            case "left":
                entityLeftCell = (entityLeft - entity.speed) / cell.height;
                tile1 = tileManager.getTileMap()[entityUpCell][entityLeftCell];
                tile2 = tileManager.getTileMap()[entityDownCell][entityLeftCell];
                if (tileManager.getTileByIndex(tile1).hasCollision() || tileManager.getTileByIndex(tile2).hasCollision()){
                    entity.isColliding = true;
                } else entity.isColliding = false;
                break;
            case "right":
                entityRightCell = (entityRight + entity.speed) / cell.height;
                tile1 = tileManager.getTileMap()[entityUpCell][entityRightCell];
                tile2 = tileManager.getTileMap()[entityDownCell][entityRightCell];
                if (tileManager.getTileByIndex(tile1).hasCollision() || tileManager.getTileByIndex(tile2).hasCollision()){
                    entity.isColliding = true;
                } else entity.isColliding = false;
                break;
        }
    }
}