
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;

public class FrameDesenhoNome 
{
    private int x0;
    private int y0;
    private String index;
    
    public FrameDesenhoNome(int x0, int y0, String index)
 {
     this.x0 = x0;
     this.y0 = y0;
     this.index = index;
 }
    
    public void desenhar(Graphics g)
 {
     g.setColor(Color.MAGENTA);
     g.drawString(index,x0+20,y0+20);
 }
}
