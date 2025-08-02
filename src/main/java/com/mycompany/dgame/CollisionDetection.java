/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dgame;

import com.mycompany.dgame.entity.Entity;
/**
 *
 * @author sun
 */
public class CollisionDetection {
    
    GamePanel gp;
    
    public CollisionDetection(GamePanel gp) {
        this.gp = gp;
    }

    public void detectCollision(Entity entity) {
        int topY = entity.worldY + entity.collisionRect.y;
        int bottomY = entity.worldY + entity.collisionRect.y + entity.collisionRect.height;
        int leftX = entity.worldX + entity.collisionRect.x;
        int rightX = entity.worldX + entity.collisionRect.x + entity.collisionRect.width;
        
        int topRow = topY / gp.tileSize;
        int bottomRow = bottomY / gp.tileSize;
        int leftCol = leftX / gp.tileSize;
        int rightCol = rightX / gp.tileSize;
        
        switch (entity.direction) {
            case "up":
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][topRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][topRow]].collision == true) {
                    gp.player.collision = true;
                } else {
                    gp.player.collision = false;
                }
                break;
            case "down":
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][bottomRow]].collision == true) {
                    gp.player.collision = true;
                } else {
                    gp.player.collision = false;
                }
                break;
            case "left":
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[leftCol][topRow]].collision == true) {
                    gp.player.collision = true;
                } else {
                    gp.player.collision = false;
                }
                break;
            case "right":
                if(gp.tileM.tiles[gp.tileM.tileMap[rightCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][topRow]].collision == true) {
                    gp.player.collision = true;
                } else {
                    gp.player.collision = false;
                }
                break;
        }
    }
    
}
