package com.testgioco.entities.collision_manager;

import com.testgioco.core.Game;
import com.testgioco.core.TileManager;
import com.testgioco.core.scenes.Play;
import com.testgioco.entities.base_classes.Entity;
import com.testgioco.entities.Player;

public class  TileCollisionManager {
    Play play;

    public TileCollisionManager(Play play){
        this.play = play;

    }
    public void checkTileCollision(Entity entity) {
        /*
         * Check if the entity is colliding with a tile
         * cA.x =8 cA.y=16 cA.width=32 cA.height=32
         */
        int entityLeftWorldX = entity.worldX + entity.collisionArea.x;
        int entityRightWorldX = entity.worldX + entity.collisionArea.x + entity.collisionArea.width;
        int entityTopWorldY = entity.worldY + entity.collisionArea.y;
        int entityBottomWorldY = entity.worldY + entity.collisionArea.y + entity.collisionArea.height;

        int entityLeftCol = entityLeftWorldX / (TileManager.cell.width*TileManager.cell.height);
        int entityRightCol = entityRightWorldX / (TileManager.cell.width*TileManager.cell.height);

        int entityTopRow = entityTopWorldY / (TileManager.cell.width*TileManager.cell.height);
        int entityBottomRow = entityBottomWorldY / (TileManager.cell.width*TileManager.cell.height);

        int tileNum1, tileNum2;


        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / TileManager.cell.height;
                tileNum1 = TileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = TileManager.mapTileNum[entityRightCol][entityTopRow];
                if(TileManager.tiles[tileNum1].collision || TileManager.tiles[tileNum2].collision){
                    entity.collisionActive = true;
                }
                break;
            case "down":
                    entityBottomRow = (entityBottomWorldY + entity.speed) / TileManager.cell.height;
                    tileNum1 = TileManager.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = TileManager.mapTileNum[entityRightCol][entityBottomRow];
                    if(TileManager.tiles[tileNum1].collision || TileManager.tiles[tileNum2].collision){
                        entity.collisionActive = true;
                    }

                break;
            case "left":
                    entityLeftCol = (entityLeftWorldX - entity.speed) / TileManager.cell.width;
                    tileNum1 = TileManager.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = TileManager.mapTileNum[entityLeftCol][entityBottomRow];
                    if(TileManager.tiles[tileNum1].collision || TileManager.tiles[tileNum2].collision){
                        entity.collisionActive = true;
                    }
                break;
            case "right":
                    entityRightCol = (entityRightWorldX + entity.speed) / TileManager.cell.width;
                    tileNum1 = TileManager.mapTileNum[entityRightCol][entityTopRow];
                    tileNum2 = TileManager.mapTileNum[entityRightCol][entityBottomRow];
                    if(TileManager.tiles[tileNum1].collision || TileManager.tiles[tileNum2].collision){
                        entity.collisionActive = true;
                    }

                break;

        }
    }


}
