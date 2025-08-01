/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import com.mycompany.dgame.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author sun
 */
public class TileManager {
    
    
    GamePanel gp;
    Tile[] tiles;
    int[][] tileMap;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[10];
        
        tileMap = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap("/maps/world01.txt");
    }
    
    public void loadMap(String mapURL) {
        
        try {
            InputStream is = getClass().getResourceAsStream(mapURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                
                String line = br.readLine();
                
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    tileMap[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col =0;
                    row++;
                }
            }
            br.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResource("/tiles/grass.png"));
            
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResource("/tiles/wall.png"));
            
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResource("/tiles/water.png"));
            
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResource("/tiles/earth.png"));
            
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResource("/tiles/tree.png"));
            
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResource("/tiles/sand.png"));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2d) {
        
        int worldCol = 0;
        int worldRow = 0;
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            
            int tileNum = tileMap[worldCol][worldRow];
            
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                
                g2d.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);    
            }
            
            
            
            worldCol++;
            if (worldCol >= gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
            
        }
    }
    
}
