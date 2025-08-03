/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obj;

import ir.najaftech.dgame.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author sun
 */
public class SuperObject {
    
    BufferedImage image;
    public int worldX, worldY;
    boolean collision =  false;
    String name;
    
    public void drawObject(Graphics2D g2d, GamePanel gp) {
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                
                g2d.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);    
            }
    }
    
}
