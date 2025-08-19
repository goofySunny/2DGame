/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.dgame;

import static ir.najaftech.dgame.AbsolutePosition.CENTER;
import static ir.najaftech.dgame.AbsolutePosition.EAST;
import static ir.najaftech.dgame.AbsolutePosition.NORTH;
import static ir.najaftech.dgame.AbsolutePosition.SOUTH;
import static ir.najaftech.dgame.AbsolutePosition.WEST;
import ir.najaftech.obj.OBJ_Key;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import static java.awt.font.TextAttribute.FONT;
import java.awt.image.BufferedImage;

/**
 *
 * @author sun
 */
public class UI {

    Graphics2D g2d;
    GamePanel gp;
    BufferedImage keyImage;
    String message = "";
    boolean showMessage = false;
    Font arial_40;
    int messageInterval = 0;
    AbsolutePosition messageAlignment;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("arial", Font.PLAIN, 40);
        keyImage = new OBJ_Key().image;
    }

    public void draw(Graphics2D g2d) {
        this.g2d = g2d;
        g2d.setFont(arial_40);
        g2d.setColor(Color.WHITE);

        if (gp.gameState == gp.playState) {
            g2d.drawImage(keyImage, 10, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2d.drawString(": " + gp.player.hasKey, 75, gp.tileSize + 12);

            if (showMessage == true) {

                switch (this.messageAlignment) {
                    case WEST:
                        g2d.drawString(message, 0, gp.maxScreenRow / 2 * gp.tileSize);
                        break;
                    case EAST:
                        break;
                    case NORTH:
                        break;
                    case CENTER:
                        FontMetrics metrics = g2d.getFontMetrics(arial_40);
                        int x = gp.maxScreenCol / 2 * gp.tileSize - (metrics.stringWidth(message) / 2);
                        int y = gp.maxScreenRow / 2 * gp.tileSize - (metrics.getHeight() / 2);
                        g2d.drawString(message, x, gp.maxScreenRow / 2 * gp.tileSize);
                        break;
                    case SOUTH:
                        break;
                }

                messageInterval++;
            }

            if (messageInterval > 120) {
                message = "";
                showMessage = false;
                messageInterval = 0;
            }
        } else if (gp.gameState == gp.pauseState) {
            drawPauseString();
        }

    }

    public void showMessage(String text, AbsolutePosition position) {
        message = text;
        showMessage = true;
        this.messageAlignment = position;
    }

    void drawPauseString() {
        g2d.setFont(g2d.getFont().deriveFont(80F));
        String pause = "PAUSED!";
        int x = gp.maxScreenCol / 2 * gp.tileSize - ((int) g2d.getFontMetrics().getStringBounds(pause, g2d).getWidth() / 2);

        g2d.drawString(pause, x, gp.maxScreenRow / 2 * gp.tileSize);
    }
}
