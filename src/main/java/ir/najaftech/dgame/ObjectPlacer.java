/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.dgame;

import obj.OBJ_Door;
import obj.OBJ_Key;

/**
 *
 * @author sun
 */
public class ObjectPlacer {
    
    GamePanel gp;
    
    public ObjectPlacer(GamePanel gp) {
        this.gp = gp;
    }
    
    public void placeObjects() {
        gp.objs[0] = new OBJ_Key();
        gp.objs[0].worldX = 23* gp.tileSize;
        gp.objs[0].worldY = 7* gp.tileSize;
        
        gp.objs[1] = new OBJ_Key();
        gp.objs[1].worldX = 23* gp.tileSize;
        gp.objs[1].worldY = 40* gp.tileSize;
//        
        gp.objs[2] = new OBJ_Key();
        gp.objs[2].worldX = 36* gp.tileSize;
        gp.objs[2].worldY = 21* gp.tileSize;
        
        gp.objs[3] = new OBJ_Door();
        gp.objs[3].worldX = 19* gp.tileSize;
        gp.objs[3].worldY = 21* gp.tileSize;
        
        gp.objs[4] = new OBJ_Door();
        gp.objs[4].worldX = 8* gp.tileSize;
        gp.objs[4].worldY = 21* gp.tileSize;
        
        gp.objs[5] = new OBJ_Door();
        gp.objs[5].worldX = 10* gp.tileSize;
        gp.objs[5].worldY = 11* gp.tileSize;
    }
    
}
