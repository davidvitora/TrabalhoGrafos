
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class FrameDesenhoAresta {
    private int x0;
    private int y0;
    private int x1;
    private int y1;
    private int index;
    private Graphics2D g;
    private Line2D linha;
            
 public FrameDesenhoAresta(int x0, int y0, int x1, int y1,int index)
 {
     this.x0 = x0;
     this.y0 = y0;
     this.x1 = x1;
     this.y1 = y1;
     this.index = index;
     linha = new Line2D.Double(x0,y0,x1,y1);
     
 }

 public void setDesenho(int x0, int y0, int x1, int y1)
 {
     this.x0 = x0;
     this.y0 = y0;
     this.x1 = x1;
     this.y1 = y1;
     linha = new Line2D.Double(x0,y0,x1,y1);
 }
  
 public Line2D getDesenho()
 {
     return linha;
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
     g.setColor(selecionado ? Color.red : Color.blue);
     this.g = (Graphics2D) g;
     this.g.draw(linha);
 }
}
