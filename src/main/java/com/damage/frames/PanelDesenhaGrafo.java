
package com.damage.frames;

import com.damage.frames.formas.FrameDesenhoAresta;
import com.damage.frames.formas.FrameDesenhoArestaParalela;
import com.damage.frames.formas.FrameDesenhoLaco;
import com.damage.frames.formas.FrameDesenhoNo;
import com.damage.frames.formas.FrameDesenhoNome;
import com.damage.frames.formas.FrameDesenhoSelecionado;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PanelDesenhaGrafo extends javax.swing.JPanel{
    
    private List<FrameDesenhoAresta> desenhaAresta;
    private List<FrameDesenhoNo> desenhaVetor;
    private List<FrameDesenhoLaco> desenhaLaco;
    private List<FrameDesenhoArestaParalela> desenhaArestaParalela;
    private List<FrameDesenhoNome> desenhaNome;
    private List<FrameDesenhoSelecionado> desenhaNoSel;
    private List<FrameDesenhoSelecionado> desenhaArestaSel;
    private List<FrameDesenhoSelecionado> desenhaArestaParaSel;
    private List<FrameDesenhoSelecionado> desenhaLacoSel;
    
    public PanelDesenhaGrafo() {
        initComponents();
        LimparVariaveis();
    }

    Component getComponent() {
        return this; 
    }
    
    public void LimparVariaveis()
    {
        desenhaAresta = new ArrayList<FrameDesenhoAresta>();    
        desenhaVetor = new ArrayList<FrameDesenhoNo>(); 
        desenhaLaco = new ArrayList<FrameDesenhoLaco>(); 
        desenhaArestaParalela = new ArrayList<FrameDesenhoArestaParalela>(); 
        desenhaNome = new ArrayList<FrameDesenhoNome>(); 
        desenhaNoSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaArestaSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaArestaParaSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaLacoSel= new ArrayList<FrameDesenhoSelecionado>();
    }
    public void AdicionarNoSelecionado(FrameDesenhoSelecionado no)
    {
        desenhaNoSel.add(no);
        validate();
        repaint();
    }
    public void AdicionarArestaSelecionado(FrameDesenhoSelecionado aresta)
    {
        desenhaArestaSel.add(aresta);
        validate();
        repaint();
    }
    public void AdicionarArestaParaSelecionado(FrameDesenhoSelecionado arestaPara)
    {
        desenhaArestaParaSel.add(arestaPara);
        validate();
        repaint();
    }
    public void AdicionarLacoSelecionado(FrameDesenhoSelecionado laco)
    {
        desenhaLacoSel.add(laco);
        validate();
        repaint();
    }
    
    public void limparSelecionados()
    {
        desenhaNoSel.removeAll(desenhaNoSel);
        desenhaArestaSel.removeAll(desenhaArestaSel);
        desenhaArestaParaSel.removeAll(desenhaArestaParaSel);
        desenhaLacoSel.removeAll(desenhaLacoSel);
        repaint();
    }
    
    public void RemoverAresta(FrameDesenhoAresta aresta)
    {
        desenhaAresta.remove(aresta);
        validate();
        repaint();
    }
    public void RemoverNo(FrameDesenhoNo no)
    {
        desenhaNome.remove(no.getIndex());
        desenhaVetor.remove(no);
        validate();
        repaint();
    }
    public void RemoverLaco(FrameDesenhoLaco laco)
    {
        desenhaLaco.remove(laco);
        validate();
        repaint();
    }
    public void RemoverArestaPara(FrameDesenhoArestaParalela arestaPara)
    {
        desenhaArestaParalela.remove(arestaPara);
        validate();
        repaint();
    }
    
    public void AdicionarNome(FrameDesenhoNome nome)
    {
        desenhaNome.add(nome);
        validate();
        repaint();
    }
    
    public void AdicionarAresta(FrameDesenhoAresta aresta)
    {
        desenhaAresta.add(aresta);
        validate();
        repaint();
    }
    public void AdicionarNo(FrameDesenhoNo no)
    {
        desenhaVetor.add(no);
        validate();
        repaint();
    }
    public void AdicionarLaco(FrameDesenhoLaco laco)
    {
        desenhaLaco.add(laco);
        validate();
        repaint();
    }
    public void AdicionarArestaParalela(FrameDesenhoArestaParalela arestaParalela)
    {
        desenhaArestaParalela.add(arestaParalela);
        validate();
        repaint();
    }
    
    public void RedesenharTudo()
    {
        desenhaNoSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaArestaSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaArestaParaSel= new ArrayList<FrameDesenhoSelecionado>();
        desenhaLacoSel= new ArrayList<FrameDesenhoSelecionado>();
        
       
        for(FrameDesenhoAresta aresta : desenhaAresta)
        {
            aresta.desenhar(this.getGraphics(),false);
            validate();
            repaint();
        }
        for(FrameDesenhoArestaParalela arestaPara : desenhaArestaParalela)
        {
            arestaPara.desenhar(this.getGraphics(),false);
            validate();
            repaint();
        }
        for(FrameDesenhoLaco laco : desenhaLaco)
        {
            laco.desenhar(this.getGraphics(),false);
            validate();
            repaint();
        }
         for(FrameDesenhoNo no : desenhaVetor)
        {
            
            no.desenhar(this.getGraphics(),false);
            validate();
            repaint();
        }
    }
    
    public FrameDesenhoNo getNo(FrameDesenhoNo no)
    {
        for(int i = 0 ; i< desenhaVetor.size() ; i ++)
        {
            if(desenhaVetor.get(i)==no)
            {
                validate();
                repaint();
             }
        }
        return no;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        for(FrameDesenhoAresta a : desenhaAresta)
        {
            a.desenhar(g, false);
        }
          for(FrameDesenhoLaco l : desenhaLaco)
        {
            l.desenhar(g, false);
        }
           for(FrameDesenhoArestaParalela a : desenhaArestaParalela)
        {
            a.desenhar(g, false);
        }
           for(FrameDesenhoNo n : desenhaVetor)
        {
            n.desenhar(g, false);
        }
           for(FrameDesenhoNome no : desenhaNome)
        {
            no.desenhar(g);
        }
           for(FrameDesenhoSelecionado no : desenhaNoSel)
        {
            no.desenharNo(g);
        }
           for(FrameDesenhoSelecionado aresta : desenhaArestaSel)
        {
            aresta.desenharAresta(g);
        }
           for(FrameDesenhoSelecionado arestaPara : desenhaArestaParaSel)
        {
            arestaPara.desenharArestaPara(g);
        }
           for(FrameDesenhoSelecionado laco : desenhaLacoSel)
        {
            laco.desenharLaco(g);
        }
    }

    public void setDesenhaAresta(List<FrameDesenhoAresta> desenhaAresta) {
        this.desenhaAresta = desenhaAresta;
    }

    public void setDesenhaVetor(List<FrameDesenhoNo> desenhaVetor) {
        this.desenhaVetor = desenhaVetor;
    }

    public void setDesenhaLaco(List<FrameDesenhoLaco> desenhaLaco) {
        this.desenhaLaco = desenhaLaco;
    }

    public void setDesenhaArestaParalela(List<FrameDesenhoArestaParalela> desenhaArestaParalela) {
        this.desenhaArestaParalela = desenhaArestaParalela;
    }

    public void setDesenhaNome(List<FrameDesenhoNome> desenhaNome) {
        this.desenhaNome = desenhaNome;
    }

    public void setDesenhaNoSel(List<FrameDesenhoSelecionado> desenhaNoSel) {
        this.desenhaNoSel = desenhaNoSel;
    }

    public void setDesenhaArestaSel(List<FrameDesenhoSelecionado> desenhaArestaSel) {
        this.desenhaArestaSel = desenhaArestaSel;
    }

    public void setDesenhaArestaParaSel(List<FrameDesenhoSelecionado> desenhaArestaParaSel) {
        this.desenhaArestaParaSel = desenhaArestaParaSel;
    }

    public void setDesenhaLacoSel(List<FrameDesenhoSelecionado> desenhaLacoSel) {
        this.desenhaLacoSel = desenhaLacoSel;
    }

    public List<FrameDesenhoAresta> getDesenhaAresta() {
        return desenhaAresta;
    }

    public List<FrameDesenhoNo> getDesenhaVetor() {
        return desenhaVetor;
    }

    public List<FrameDesenhoLaco> getDesenhaLaco() {
        return desenhaLaco;
    }

    public List<FrameDesenhoArestaParalela> getDesenhaArestaParalela() {
        return desenhaArestaParalela;
    }

    public List<FrameDesenhoNome> getDesenhaNome() {
        return desenhaNome;
    }

    public List<FrameDesenhoSelecionado> getDesenhaNoSel() {
        return desenhaNoSel;
    }

    public List<FrameDesenhoSelecionado> getDesenhaArestaSel() {
        return desenhaArestaSel;
    }

    public List<FrameDesenhoSelecionado> getDesenhaArestaParaSel() {
        return desenhaArestaParaSel;
    }

    public List<FrameDesenhoSelecionado> getDesenhaLacoSel() {
        return desenhaLacoSel;
    }
           
           private void initComponents() {

        this.setPreferredSize(new java.awt.Dimension(750, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
    }
}

