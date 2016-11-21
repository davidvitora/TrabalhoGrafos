
package com.damage.frames.formas;

import java.awt.Color;
import java.awt.Graphics;


public class FrameDesenhoSelecionado {
    
    private FrameDesenhoNo selNo;

    public FrameDesenhoNo getSelNo() {
        return selNo;
    }

    public FrameDesenhoAresta getSelAresta() {
        return selAresta;
    }

    public FrameDesenhoArestaParalela getSelArestaPara() {
        return selArestaPara;
    }

    public FrameDesenhoLaco getSelLaco() {
        return selLaco;
    }
    private FrameDesenhoAresta selAresta;
    private FrameDesenhoArestaParalela selArestaPara;
    private FrameDesenhoLaco selLaco;
    
    
    public FrameDesenhoSelecionado(FrameDesenhoNo selNo)
 {
     this.selNo = selNo;
 }
    public FrameDesenhoSelecionado(FrameDesenhoAresta selAresta)
 {
     this.selAresta = selAresta;
 }
    public FrameDesenhoSelecionado(FrameDesenhoArestaParalela selArestaPara)
 {
     this.selArestaPara = selArestaPara;
 }
    public FrameDesenhoSelecionado(FrameDesenhoLaco selLaco)
 {
     this.selLaco = selLaco;
 }
    
    public void desenharNo(Graphics g)
 {
     selNo.desenhar(g, true);
 }
    public void desenharAresta(Graphics g)
 {
     selAresta.desenhar(g, true);
 }
    public void desenharArestaPara(Graphics g)
 {
     selArestaPara.desenhar(g, true);
 }
    public void desenharLaco(Graphics g)
 {
     selLaco.desenhar(g,true);
 }
}
