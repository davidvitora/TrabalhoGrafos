/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;


public class FrameDesenhoArestaParalela {
    private int x0;
    private int y0;
    private int x1;
    private int y1;  
    int index;
    int contPara;
    CubicCurve2D linha;
    private Graphics2D g;
    
    public FrameDesenhoArestaParalela(int x0, int y0, int x1, int y1, int index, int contPara)
    {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.index = index;
        this.contPara = contPara;
        this.linha = new CubicCurve2D.Double(x0+10, y0+10, x0-15-contPara*35,y0-15-contPara*35, x1-15-contPara*35, y1-15-contPara*35, x1+10, y1+10);
    }
    
    public int getIndex()
    {
        return this.index;
    }
    public CubicCurve2D getDesenho()
 {
     return linha;
 }
    public void desenhar(Graphics g, boolean selecionado)
 {
     g.setColor(selecionado ? Color.red : Color.blue);
     this.g = (Graphics2D) g;
     this.g.draw(linha);
 }
}
