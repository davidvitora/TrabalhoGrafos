
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class FrameDesenhoLaco {
      private int x0;
      private int y0;
      private int tamanho;
      private int contLaco;
      private int index;
      private Graphics2D g;
      private Ellipse2D laco;
      
      public FrameDesenhoLaco(int x0, int y0, int index, int contLaco)
 {
     this.x0 = x0;
     this.y0 = y0;
     this.index = index;
     laco = new Ellipse2D.Double(x0, y0, 25+(contLaco*10), 25+(contLaco*10));
     this.contLaco = contLaco;
 }
      public void desenhar(Graphics g, boolean selecionado )
 {
     g.setColor(selecionado ? Color.red : Color.green);
     this.g = (Graphics2D) g;
     this.g.draw(laco);
 }
     public Ellipse2D getDesenho()
     {
         return this.laco;
     }
      public int getIndex()
      {
          return index;
      }
      public void setIndex(int index)
      {
          this.index = index;
      }      
              }
