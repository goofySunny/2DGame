/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dgame.entity;

import java.awt.image.BufferedImage;

/**
 *
 * @author sun
 */
public class Entity {
    
    public int x, y;
    public int speed;
    
    BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    
}
