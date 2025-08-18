/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.entity;

import ir.najaftech.dgame.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author sun
 */
public class Entity {
    
    public int worldX, worldY;
    public int speed;
    
    BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
    public String direction;
    
    public int spriteMax = 2;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public boolean collision = false;
    
    GamePanel gp;
    
    public Rectangle collisionRect;
    public int collisionDefaultX, collisionDefaultY;
    
    public Entity(int maxSprites, GamePanel gp) {
        this.spriteMax = maxSprites;
        this.gp = gp;
    }
    
    public void getEntityImage() {}
    
}
