/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.dgame;

import ir.najaftech.entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;
import ir.najaftech.obj.SuperObject;
import tile.TileManager;

/**
 *
 * @author sun
 */
public class GamePanel extends JPanel implements Runnable {
    
    final int originalTileSize = 16;
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    final int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    
    public Player player = new Player(this, keyH);
    public ObjectPlacer objectPlacer = new ObjectPlacer(this);
    public CollisionDetection cd = new CollisionDetection(this);
    TileManager tileM = new TileManager(this);
    
    private Thread gameThread;
    
//    WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
//    Objects
    SuperObject objs[] = new SuperObject[10];
    
    public GamePanel() {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.requestFocus();
    }
    
    void update() {
        player.update();
    }
    
    public void initGame() {
        gameThread = new Thread(this);
        
        gameThread.start();
    }
    
    public void loadObjects() {
        objectPlacer.placeObjects();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        
        
        while (gameThread != null) {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
        
            
            if (delta >= 1) {
                update();
                repaint();
                Toolkit.getDefaultToolkit().sync();
                delta--;
                drawCount++;
            }
            
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
//        TILES
        tileM.draw(g2d);
        
//        OBJECTS
        for (int i=0; i < objs.length; i++) {
            if (objs[i] != null) {
                objs[i].drawObject(g2d, this);
            }
        }
        
//        PLAYER
        player.draw(g2d);
        g2d.dispose();
    }
}






