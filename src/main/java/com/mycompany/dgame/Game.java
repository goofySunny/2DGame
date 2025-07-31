/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dgame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author sun
 */
public class Game {

    public static void main(String[] args) {
        
        GamePanel gamepanel = new GamePanel();
        JFrame mainFrame = new JFrame("2DGame");
        
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(gamepanel);
        mainFrame.pack();
        gamepanel.initGame();
    }
}
