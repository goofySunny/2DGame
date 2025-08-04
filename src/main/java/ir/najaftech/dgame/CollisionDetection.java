/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.dgame;

import ir.najaftech.entity.Entity;
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
                topRow = (topY - entity.speed)/gp.tileSize;
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][topRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][topRow]].collision == true) {
                    gp.player.collision = true;
                }
                break;
            case "down":
                bottomRow = (bottomY + entity.speed)/gp.tileSize;
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][bottomRow]].collision == true) {
                    gp.player.collision = true;
                }
                break;
            case "left":
                leftCol = (leftX - entity.speed)/gp.tileSize;
                if(gp.tileM.tiles[gp.tileM.tileMap[leftCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[leftCol][topRow]].collision == true) {
                    gp.player.collision = true;
                }
                break;
            case "right":
                rightCol = (rightX + entity.speed)/gp.tileSize;
                if(gp.tileM.tiles[gp.tileM.tileMap[rightCol][bottomRow]].collision == true ||
                    gp.tileM.tiles[gp.tileM.tileMap[rightCol][topRow]].collision == true) {
                    gp.player.collision = true;
                }
                break;
        }
    }
    
}
