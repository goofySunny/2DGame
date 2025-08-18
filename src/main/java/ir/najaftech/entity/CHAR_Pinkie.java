/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.entity;

import ir.najaftech.dgame.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author sun
 */
public class CHAR_Pinkie extends Entity {

    private int deciderInterval = 120;
    private int deciderHold = 0;
    boolean moving = true;

    public CHAR_Pinkie(int maxSprites, GamePanel gp) {
        super(4, gp);

        setDefaultValues();
        getEntityImage();
        direction = "down";
    }

    void setDefaultValues() {
        worldX = gp.tileSize * 21;
        worldY = gp.tileSize * 21;
        speed = 1;
        collisionRect = new Rectangle(gp.tileSize / 3, gp.tileSize / 4, gp.tileSize / 3, gp.tileSize / 4 * 3);
        collisionDefaultX = collisionRect.x;
        collisionDefaultY = collisionRect.y;
    }

    @Override
    public void getEntityImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_up_01.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_up_04.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_left_01.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_left_04.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_right_01.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_right_04.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_down_01.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/pinkie/pinkie_down_04.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void decideRandomMovement() {
        Random random = new Random();
        long randomNumber = random.nextLong(100) + 1;
        moving = true;
        if (randomNumber < 20) {
            direction = "up";
        } else if (randomNumber < 40) {
            direction = "down";
        } else if (randomNumber < 60) {
            direction = "right";
        } else if (randomNumber < 80) {
            direction = "left";
        } else {
            moving = false;
        }
    }

    public void update() {
        if (deciderHold > deciderInterval) {
            decideRandomMovement();
            deciderHold = 0;
        }
        
//        Collision Detection
        collision = false;
        gp.cd.detectTileCollision(this);
        
        if (moving == true && collision == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
        deciderHold++;

    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;

            switch (direction) {
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                if (spriteNumber == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                }
                if (spriteNumber == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                break;
        }
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                && worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            g2d.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
