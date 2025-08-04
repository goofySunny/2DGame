/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.dgame;

import ir.najaftech.obj.OBJ_Key;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author sun
 */
public class UI {

    GamePanel gp;
    BufferedImage keyImage;
    String message = "";
    boolean showMessage = false;
    Font arial_40;
    int messageInterval = 0;
    
    public UI(GamePanel gp) {
        this.gp = gp;
        
        arial_40 = new Font("arial", Font.PLAIN, 40);
        keyImage = new OBJ_Key().image;
    }
    
    public void draw(Graphics2D g2d) {
        g2d.setFont(arial_40);
        g2d.setColor(Color.WHITE);
        
        g2d.drawImage(keyImage, 10, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2d.drawString(": " + gp.player.hasKey, 75, gp.tileSize + 12);
        
        if (showMessage == true) {
            g2d.drawString(message, 0, gp.maxScreenRow/2*gp.tileSize);
            messageInterval++;
        }
        
        if (messageInterval > 120) {
            message = "";
            showMessage = false;
            messageInterval = 0;
        }
        
    }
    
    public void showMessage(String text) {
        message = text;
        showMessage = true;
    }
}
