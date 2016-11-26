/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.util;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author David .V
 */
public class MudarIcone {
  
    public static void mudarIcone(JFrame frame){
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("forkico.png"));
    }
    
}
