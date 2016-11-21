
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;

public class FrameDesenhoNo 
{
    private int x0;
    private int y0;
    private int tamanho = 20;
    private int index;
    
    public FrameDesenhoNo(int x0, int y0, int index)
 {
     this.x0 = x0;
     this.y0 = y0;
     this.index = index;
 }
    
    public int getIndex()
 {
     return index;
 }
    public void setIndex(int index)
 {
     this.index = index;
 } 
    public void desenhar(Graphics g, boolean selecionado)
 {
     g.setColor(selecionado ? Color.red : Color.black);
     g.fillOval(x0, y0, tamanho, tamanho);
 }
}
