package com.testgioco.entities.collision_manager;


import com.testgioco.core.TileManager;
import com.testgioco.core.handlers.InputHandler;
import com.testgioco.entities.Player;
/*
Calcolo della posizione futura del giocatore: Utilizza le variabili futureX e futureY
per rappresentare la posizione
futura del giocatore in base
alla direzione di input fornita
 dall'InputHandler e alla velocità del giocatore (player.speed).

 */
public class CollisionManager {
    private static final int TILE_INDEX_OF_WALL = 1;
    private TileManager tileManager;
    private Player player;
    private InputHandler inputHandler;

    public CollisionManager(TileManager tileManager, Player player, InputHandler inputHandler) {
        this.tileManager = tileManager;
        this.player = player;
        this.inputHandler = inputHandler;
    }

    public boolean canMove() {
        int futureX = player.positionOnTheMap.getX();
        int futureY = player.positionOnTheMap.getY();
        int tileSize = tileManager.cell.width;

        if (inputHandler.upPressed) {
            futureY -= player.speed;
        }
        if (inputHandler.downPressed) {
            futureY += player.speed;
        }
        if (inputHandler.leftPressed) {
            futureX -= player.speed;
        }
        if (inputHandler.rightPressed) {
            futureX += player.speed;
        }

        int futureTileColumn = futureX / tileSize;
        int futureTileRow = futureY / tileSize;

        // Controlla se il movimento colpisce un muro
        return canMoveToTile(futureTileRow, futureTileColumn, futureX, futureY);
    }

    private boolean canMoveToTile(int tileRow, int tileColumn, int futureX, int futureY) {
        boolean withinBounds = tileRow >= 0 && tileRow < tileManager.mapTileNum.length &&
                tileColumn >= 0 && tileColumn < tileManager.mapTileNum[0].length;

        if (!withinBounds) {
            return false;
        }

        int tileX = tileColumn * tileManager.cell.width;
        int tileY = tileRow * tileManager.cell.height;

        boolean collides = tileManager.mapTileNum[tileRow][tileColumn] == TILE_INDEX_OF_WALL;

        int playerWidth = player.getPlayerWidth(); // Ottieni la larghezza del giocatore
        int playerHeight = player.getPlayerHeight(); // Ottieni l'altezza del giocatore

        // Verifica se il personaggio si sovrappone al tile del muro considerando un offset
        boolean collidesWithWall = futureX + playerWidth > tileX &&
                futureX < tileX + tileManager.cell.width &&
                futureY + playerHeight > tileY &&
                futureY < tileY + tileManager.cell.height;

        return !collides || !collidesWithWall;
    }


}