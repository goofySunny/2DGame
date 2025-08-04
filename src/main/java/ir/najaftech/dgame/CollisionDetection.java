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

    public void detectTileCollision(Entity entity) {
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
    
    public int detectObjectCollision(Entity entity, boolean player) {
        int index = 999;
        
        for (int i = 0; i < gp.objs.length; i++) {
            if (gp.objs[i] != null) {
                //            Entity Coordinates
                entity.collisionRect.x = entity.collisionRect.x + entity.worldX;
                entity.collisionRect.y = entity.collisionRect.y + entity.worldY;
    //            Object Coordinates
                gp.objs[i].collisionRect.x = gp.objs[i].collisionRect.x + gp.objs[i].worldX;
                gp.objs[i].collisionRect.y = gp.objs[i].collisionRect.y + gp.objs[i].worldY;

                switch (entity.direction) {
                    case "up":
                        entity.collisionRect.y -= entity.speed;
                        if (entity.collisionRect.intersects(gp.objs[i].collisionRect)) {
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.collisionRect.y += entity.speed;
                        if (entity.collisionRect.intersects(gp.objs[i].collisionRect)) {
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.collisionRect.x -= entity.speed;
                        if (entity.collisionRect.intersects(gp.objs[i].collisionRect)) {
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.collisionRect.x += entity.speed;
                        if (entity.collisionRect.intersects(gp.objs[i].collisionRect)) {
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.collisionRect.x = entity.collisionDefaultX;
                entity.collisionRect.y = entity.collisionDefaultY;

                gp.objs[i].collisionRect.x = 0;
                gp.objs[i].collisionRect.y = 0;
            }
        }
        return index;
    }
    
}
