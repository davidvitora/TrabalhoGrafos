
package com.damage.frames;

import com.damage.frames.formas.FrameDesenhoAresta;
import com.damage.frames.formas.FrameDesenhoArestaParalela;
import com.damage.frames.formas.FrameDesenhoLaco;
import com.damage.frames.formas.FrameDesenhoNo;
import com.damage.frames.formas.FrameDesenhoNome;
import com.damage.frames.formas.FrameDesenhoSelecionado;
import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;
import com.damage.modeloTabelaGrafos.ModeloTabelaGrafos;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;


public class DesenhaGrafos extends javax.swing.JFrame {
private boolean selecionado = false,selecionadoItem = false, selecionadoVermelho=false, graficoModifica = false;
private int eixoX,eixoY, indexNo=-1, indexAresta=-1, divisor =1, indexGrafo =-1;  
private VectorAresta<Aresta> aresta = new VectorAresta();
private VectorNo<No> no = new VectorNo();
private No no1, no2;
private Aresta arestaNova = new Aresta();
private ModeloTabelaGrafos modelo;
private Grafo grafo; 
private FrameDesenhoSelecionado itemSelecionado;

    public DesenhaGrafos() {
       
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }
    
    public DesenhaGrafos(ModeloTabelaGrafos modelo) {
        this.modelo = modelo;
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPop = new javax.swing.JPopupMenu();
        excluir = new javax.swing.JMenuItem();
        panelDesenha = new com.damage.frames.PanelDesenhaGrafo();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSalvar = new javax.swing.JMenu();
        menuGravar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        menuPop.add(excluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Desenha Grafo");

        panelDesenha.setBackground(new java.awt.Color(255, 255, 255));
        panelDesenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDesenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDesenhaLayout = new javax.swing.GroupLayout(panelDesenha);
        panelDesenha.setLayout(panelDesenhaLayout);
        panelDesenhaLayout.setHorizontalGroup(
            panelDesenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        panelDesenhaLayout.setVerticalGroup(
            panelDesenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        menuSalvar.setText("Arquivo");

        menuGravar.setText("Salvar");
        menuGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGravarActionPerformed(evt);
            }
        });
        menuSalvar.add(menuGravar);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSalvar.add(jMenuItem1);

        jMenuBar1.add(menuSalvar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDesenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDesenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(766, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void menuGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGravarActionPerformed

        if(graficoModifica)
     {
        grafo.setAresta(aresta);
        grafo.setNo(no);
        grafo.update();
        modelo.getGrafos().set(indexGrafo, grafo);
        graficoModifica = false;
     }
     else
     {
     String nome = "";
     while( nome.length() < 1)
      {
          nome = JOptionPane.showInputDialog(this, "Digite um nome: ", "Nome", 1);
          if(nome==null)
          {
              return;
          }
      }    
      
      grafo = new Grafo();
      grafo.setNome(nome);
      grafo.setAresta(aresta);
      grafo.setNo(no);
      grafo.update();
      modelo.getGrafos().add(grafo);
      modelo.fireTableDataChanged();
     }
     
     modelo.fireTableDataChanged();
     this.dispose();       
    }//GEN-LAST:event_menuGravarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           
        this.dispose(); 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void panelDesenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDesenhaMouseClicked
        
        panelDesenha.RedesenharTudo();
        boolean botaoDireito = evt.getButton()==MouseEvent.BUTTON3;
        if(botaoDireito)
        {
        menuPop.show(panelDesenha.getComponent(), evt.getX(), evt.getY());
        panelDesenha.repaint();
         for(FrameDesenhoArestaParalela dA : panelDesenha.getDesenhaArestaParalela())
        {
            if(dA.getDesenho().intersects(evt.getX(), evt.getY(), 25, 25))
            {
                if(getNo(evt.getX(),evt.getY())==null)
                {
                DesenhaSelecionadoArestaParalela(dA);
                return;
                }
            }
        }
        for(FrameDesenhoAresta dA : panelDesenha.getDesenhaAresta())
        {
            if(dA.getDesenho().intersects(evt.getX(), evt.getY(), 25, 25))
            {
                if(getNo(evt.getX(),evt.getY())==null)
                {
                DesenhaSelecionadoAresta(dA);
                return;
                }
            }
        }
         
      for(FrameDesenhoLaco dL : panelDesenha.getDesenhaLaco())
        {
            if(dL.getDesenho().intersects(evt.getX(), evt.getY(), 25, 25))
            {
                if(getNo(evt.getX(),evt.getY())==null)
                {
                DesenhaSelecionadoLaco(dL);
                return;
                }
            }
        }
          
        no1 = getNo(evt.getX(),evt.getY());
        if(no1!=null)
        {
            selecionado=true;
            selecionadoItem = true;
            DesenhaSelecionadoNo();
            no1=null;
            no2=null;
        }
     }
         
        
       if(!selecionadoItem&&!botaoDireito)
       {
           arestaNova = new Aresta();
            if(selecionado)
            {   
                no2 = getNo(evt.getX(),evt.getY());
                
                    if(no2!=null)
                    {
                        arestaNova.setNo1(no1);
                        arestaNova.setNo2(no2);
                        if(no1==no2)
                        {
                            arestaNova.setContLaco(GetLaco()+1);
                        }
                        else
                        {
                            no.getNo(no2.getIndex()).getArestas().add(arestaNova);
                        }
                        no.getNo(no1.getIndex()).getArestas().add(arestaNova);
                        indexAresta++;
                        arestaNova.setId(Integer.toString(indexAresta));
                        arestaNova.setIndex(indexAresta);
                        aresta.add(arestaNova);

                    }
                    else
                    {
                        selecionado=false;
                    }
                     
            }
                else  
            {
             no1 = getNo(evt.getX(),evt.getY());
                
                    if(no1==null)
                    {
                       String nome="";
                       while(nome.replaceAll(" ", "").length()<1)
                       {
                           repaint();
                           nome = JOptionPane.showInputDialog(this, "Digite um nome para o Nó: ");
                           if(nome==null)
                           {
                                nome = "";
                                return;
                           }
                           if(nome.replaceAll(" ", "").length()<1)
                           {
                               JOptionPane.showMessageDialog(this, "Nome invalido!", "Nome Invalido", 1);
                           }
                       }
                       selecionadoVermelho=false;
                       no1 = new No();
                       no1.setCordenadaX(evt.getX()-10);
                       no1.setCordenadaY(evt.getY()-10);
                       indexNo++;
                       repaint();
                       no1.setId(nome);
                       no1.setIndex(no.size());
                       no.add(no1);
                       }
                    else
                        selecionado=true;
                   }
               
            VerificaDesenho();
          
       }
         else
            {
                selecionadoItem=false;
                repaint();
            }
             
     
    }//GEN-LAST:event_panelDesenhaMouseClicked

    public void excluirAresta()
    {
         if(panelDesenha.getDesenhaArestaSel().size()!=0)
            {
                for(FrameDesenhoAresta a : panelDesenha.getDesenhaAresta())
                {
                   if(itemSelecionado.getSelAresta().getIndex()==a.getIndex())
                   {
                       selecionadoItem=false;
                       for(int j = 0 ; j < no.size() ; j++)
                       {
                         for(int i = 0; i< no.getNo(j).getArestas().size();i++)
                          {
                              if(no.getNo(j).getArestas().getAresta(i).getIndex()==a.getIndex())
                              {
                                  no.getNo(j).getArestas().remove(i);
                              }
                          }
                       }
                       indexAresta--;
                       panelDesenha.limparSelecionados();
                       panelDesenha.RemoverAresta(a);
                       panelDesenha.RedesenharTudo();
                       aresta.remove(a.getIndex());
                       retornaIndexAresta();
                       repaint();
                       return;
                       
                   }
                }
                
            }
    }
    
    public void excluirArestaPara()
    {
              
            if(panelDesenha.getDesenhaArestaParaSel().size()!=0)
            {
                        if(selecionadoItem||selecionado)
                {
                    if(panelDesenha.getDesenhaArestaParaSel()!=null)
                    {
                        for(FrameDesenhoArestaParalela a : panelDesenha.getDesenhaArestaParalela())
                        {
                           if(itemSelecionado.getSelArestaPara().getIndex()==a.getIndex())
                           {
                               selecionadoItem=false;
                               for(int j = 0 ; j < no.size() ; j++)
                               {
                                 for(int i = 0; i< no.getNo(j).getArestas().size();i++)
                                  {
                                      if(no.getNo(j).getArestas().getAresta(i).getIndex()==a.getIndex())
                                      {
                                          no.getNo(j).getArestas().remove(i);
                                      }
                                  }
                               }
                               indexAresta--;
                               panelDesenha.limparSelecionados();
                               panelDesenha.RemoverArestaPara(a);
                               panelDesenha.RedesenharTudo();
                               aresta.remove(a.getIndex());
                               retornaIndexAresta();
                               repaint();
                               return;

                           }
                        }
                
            }
                }
            }
    }
    
    public void excluirLaco()
    {
         if(panelDesenha.getDesenhaLacoSel().size()!=0)
            {
                  if(selecionadoItem||selecionado)
                {
                    if(panelDesenha.getDesenhaArestaParaSel()!=null)
                    {
                        for(FrameDesenhoLaco a : panelDesenha.getDesenhaLaco())
                        {
                           if(itemSelecionado.getSelLaco().getIndex()==a.getIndex())
                           {
                               selecionadoItem=false;
                               for(int j = 0 ; j < no.size() ; j++)
                               {
                                 for(int i = 0; i< no.getNo(j).getArestas().size();i++)
                                  {
                                      if(no.getNo(j).getArestas().getAresta(i).getIndex()==a.getIndex())
                                      {
                                          no.getNo(j).getArestas().remove(i);
                                      }
                                  }
                               }
                               indexAresta--;
                               panelDesenha.limparSelecionados();
                               panelDesenha.RemoverLaco(a);
                               panelDesenha.RedesenharTudo();
                               aresta.remove(a.getIndex());
                               retornaIndexAresta();
                               repaint();
                               return;

                           }
                        }
                
                    }
                }
            }
    }
    
    public boolean excluirNo()
    {
         if(panelDesenha.getDesenhaNoSel().size()!=0)
            {
              for(FrameDesenhoNo a : panelDesenha.getDesenhaVetor())
                {
                   if(itemSelecionado.getSelNo().getIndex()==a.getIndex())
                   {
                       if(!no.getNo(a.getIndex()).getArestas().isEmpty())
                       {
                           JOptionPane.showMessageDialog(this, "O nó selecionado está sendo utilizado em arestas\nRealize a exclusão da aresta para prosseguir", "Exclua a aresta", 1);
                           panelDesenha.limparSelecionados();
                           repaint();
                           return false;
                       }
                       else
                       {
                       indexNo--;
                       selecionadoItem=false;
                       no.remove(a.getIndex());
                       panelDesenha.limparSelecionados();
                       panelDesenha.RemoverNo(a);
                       panelDesenha.RedesenharTudo();
                       retornaIndexNo();
                       repaint();
                       return true;
                       }
                       
                   }
                }
            }
         return false;
    }
      
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        
        if(selecionadoItem||selecionado)
        {
             if(excluirNo());
             {
             excluirAresta();
             excluirArestaPara();
             excluirLaco();   
             }
        }
        
    }//GEN-LAST:event_excluirActionPerformed
     
    public void retornaIndexNo()
    {
        if(no.size()==1)
        {
            no.getNo(0).setIndex(0);
            panelDesenha.getDesenhaVetor().get(0).setIndex(0);
        }
        else{
            for(int i=0; i<no.size()-1;i++)
                {
                    if(i==0&&no.getNo(i).getIndex()-1!=-1)
                    {
                        no.getNo(i).setIndex(0);
                        panelDesenha.getDesenhaVetor().get(i).setIndex(0);
                    }   
                    if(no.getNo(i).getIndex()+1!=no.getNo(i+1).getIndex())
                    {
                        no.getNo(i+1).setIndex(no.getNo(i+1).getIndex()-1);
                        panelDesenha.getDesenhaVetor().get(no.getNo(i+1).getIndex()).setIndex(no.getNo(i+1).getIndex());
                        i--;
                    }
                }
            }
    }
    
     public void retornaIndexAresta()
    {
        if(aresta.size()==1)
                {
                    aresta.getAresta(0).setIndex(0);
                    panelDesenha.getDesenhaAresta().get(0).setIndex(0);
                }
        else{
            for(int i=0; i<aresta.size()-1;i++)
                {
                    if(i==0&&aresta.getAresta(i).getIndex()-1!=-1)
                    {
                        aresta.getAresta(i).setIndex(0);
                        panelDesenha.getDesenhaAresta().get(i).setIndex(0);
                    }   
                    
                     if(aresta.getAresta(i).getIndex()+1!=aresta.getAresta(i+1).getIndex())
                    {
                        
                        aresta.getAresta(i+1).setIndex(aresta.getAresta(i+1).getIndex()-1);
                        panelDesenha.getDesenhaAresta().get(aresta.getAresta(i+1).getIndex()).setIndex(aresta.getAresta(i+1).getIndex());
                        i--;
                    }
                }
            }
    }
     
    public PanelDesenhaGrafo AbrirGrafo(Grafo grafo,PanelDesenhaGrafo preview,int indexGrafo, boolean preVisualiza)
    { 
        this.indexGrafo = indexGrafo;
        this.grafo = grafo;
        graficoModifica = preVisualiza ? false : true;
        if(preVisualiza)
        panelDesenha = preview;
        
        divisor = preVisualiza ? 2 :1;
         for(int i =0; i<grafo.getAresta().size(); i++)
        {
            arestaNova=grafo.getAresta().getAresta(i);
            no1=arestaNova.getNo1();
            no2=arestaNova.getNo2();
            indexAresta++;
            aresta.add(arestaNova);
            selecionado=true;
            VerificaDesenho();
        }
         for(int i =0; i<grafo.getNo().size(); i++)
        {
            no1=grafo.getNo().getNo(i);
            no.add(no1);
            indexNo++;
            VerificaDesenho();
        }
        
       
        return panelDesenha;
    }  
    
    public void DesenhaParalelo(int contPara)
    {
         
            FrameDesenhoArestaParalela desenhaParalelo = new FrameDesenhoArestaParalela(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor, no2.getCordenadaX()/divisor, no2.getCordenadaY()/divisor,no1.getIndex(), contPara);
            panelDesenha.AdicionarArestaParalela(desenhaParalelo);
            desenhaParalelo.desenhar(panelDesenha.getGraphics(), selecionado);
            panelDesenha.RedesenharTudo();
            selecionado=false;
            repaint();
            
    }       
    
    public void DesenhaLaco(int contLaco)
    {
            FrameDesenhoLaco desenhaLaco = new FrameDesenhoLaco(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor,arestaNova.getIndex(),contLaco);
            panelDesenha.AdicionarLaco(desenhaLaco);
            desenhaLaco.desenhar(panelDesenha.getGraphics(), false);
            selecionado=false;
            panelDesenha.RedesenharTudo();
            repaint();
    }
    
    public void DesenhaAresta()
    {       
            if(VerificaParalelo())
            {
                DesenhaParalelo(arestaNova.getContParalelo());
            }
            else
            {
            FrameDesenhoAresta desenhoAresta = new FrameDesenhoAresta((no1.getCordenadaX()+10)/divisor, (no1.getCordenadaY()+10)/divisor, (no2.getCordenadaX()+10)/divisor, (no2.getCordenadaY()+10)/divisor, arestaNova.getIndex());
            panelDesenha.AdicionarAresta(desenhoAresta);
            desenhoAresta.desenhar(panelDesenha.getGraphics(),false);
            panelDesenha.RedesenharTudo();
           
            }
            repaint();
            selecionado=false;
            DesenhaSelecionadoNo();
            no1=null;
            no2=null;
            arestaNova = new Aresta();
    }
    
    public void DesenhaVetor()
    {
            FrameDesenhoNo desenhaNo = new FrameDesenhoNo(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor,no1.getIndex());
            panelDesenha.AdicionarNo(desenhaNo);
            desenhaNo.desenhar(panelDesenha.getGraphics(), selecionado);
            FrameDesenhoNome desenhaNome = new FrameDesenhoNome(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor,no.getNo(indexNo).getId());
            panelDesenha.AdicionarNome(desenhaNome);
            desenhaNome.desenhar(panelDesenha.getGraphics());
            repaint();
    }
    
    public void DesenhaSelecionadoArestaParalela(FrameDesenhoArestaParalela dA)
    {
         dA.desenhar(panelDesenha.getGraphics(), true);
         itemSelecionado = new FrameDesenhoSelecionado(dA);
         panelDesenha.AdicionarArestaParaSelecionado(itemSelecionado);
         itemSelecionado.desenharArestaPara(panelDesenha.getGraphics());
         repaint();
         selecionadoItem=true;
    }
    
    public void DesenhaSelecionadoAresta(FrameDesenhoAresta dA)
    {
         dA.desenhar(panelDesenha.getGraphics(), true);
         itemSelecionado = new FrameDesenhoSelecionado(dA);
         panelDesenha.AdicionarArestaSelecionado(itemSelecionado);
         itemSelecionado.desenharAresta(panelDesenha.getGraphics());
         repaint();
         selecionadoItem=true;
    }
    
    public void DesenhaSelecionadoLaco(FrameDesenhoLaco dL)
    {
        dL.desenhar(panelDesenha.getGraphics(), true);
        itemSelecionado = new FrameDesenhoSelecionado(dL);
        panelDesenha.AdicionarLacoSelecionado(itemSelecionado);
        itemSelecionado.desenharLaco(panelDesenha.getGraphics());
        repaint();
        selecionadoItem = true;
    }
    
    public void DesenhaSelecionadoNo()
    {       
            if(selecionado)
            {
            FrameDesenhoNo desenhaNo = new FrameDesenhoNo(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor,no1.getIndex());
            itemSelecionado = new FrameDesenhoSelecionado(desenhaNo);
            panelDesenha.AdicionarNoSelecionado(itemSelecionado);
            itemSelecionado.desenharNo(panelDesenha.getGraphics());
            selecionadoVermelho=true;
            }
            else
            {
            FrameDesenhoNo desenhaNo = new FrameDesenhoNo(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor,no1.getIndex());
            desenhaNo.desenhar(panelDesenha.getGraphics(), false);
            panelDesenha.limparSelecionados();
            panelDesenha.RedesenharTudo();
             no1=null;
             no2=null;
             selecionadoVermelho=false;
            }
            repaint();
    }
    
    public int GetLaco()
    {
        int index = -1;
        for(int i=0; i<aresta.size(); i++)
                        {
                            if(aresta.getAresta(i).getNo1()==no1&&aresta.getAresta(i).getNo2()==no2)
                            {
                                 index = index<aresta.getAresta(i).getContLaco() ? aresta.getAresta(i).getContLaco() : index;
                            }
                        }
        return index;
    }
    
    public boolean VerificaParalelo()
    {
        boolean paralelo = false;
        for(int i=0; i<aresta.size(); i++)
                        {
                            if(aresta.getAresta(i)!=arestaNova){
                            if(aresta.getAresta(i).getNo1().getCordenadaX()==no1.getCordenadaX()&&aresta.getAresta(i).getNo2().getCordenadaX()==no2.getCordenadaX()&&aresta.getAresta(i).getNo1().getCordenadaY()==no1.getCordenadaY()&&aresta.getAresta(i).getNo2().getCordenadaY()==no2.getCordenadaY()||aresta.getAresta(i).getNo1().getCordenadaX()==no2.getCordenadaX()&&aresta.getAresta(i).getNo2().getCordenadaX()==no1.getCordenadaX()&&aresta.getAresta(i).getNo1().getCordenadaY()==no2.getCordenadaY()&&aresta.getAresta(i).getNo2().getCordenadaY()==no1.getCordenadaY())
                            {
                                paralelo= true;
                                if(arestaNova.getContParalelo()<=aresta.getAresta(i).getContParalelo())
                                   arestaNova.setContParalelo(aresta.getAresta(i).getContParalelo()+1);
                            }
                        }
                        }
        
        return paralelo;
    }
    
    public void VerificaDesenho()
    {
        if(selecionado)
        { 
            if(no1!=null&&no2!=null)
                 {
                     if(no1.getCordenadaX()==no2.getCordenadaX()&&no1.getCordenadaY()==no2.getCordenadaY())
                        {  
                           DesenhaLaco(arestaNova.getContLaco());
                           selecionado = false;
                           DesenhaSelecionadoNo();
                        }
                     else 
                        {
                            DesenhaAresta(); 
                        }
                 }
            else
                {
                     DesenhaSelecionadoNo();

                }

             }
             else if(!no.isEmpty()&&!selecionadoVermelho)
             {
                 DesenhaVetor();
             }

           repaint();  

    }
           
   public No getNo(int getX, int getY)
   {
        for(int i=0; i<no.size();i++)
            {
                if(getX<=no.getNo(i).getCordenadaX()+20&&getX>=no.getNo(i).getCordenadaX()-20&&getY<=no.getNo(i).getCordenadaY()+20&&getY>=no.getNo(i).getCordenadaY()-20)
                {return no.getNo(i);}
            }
        return null;
   }
   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
    
    public static void  abrir(ModeloTabelaGrafos modelo){
        new DesenhaGrafos(modelo).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem excluir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuGravar;
    private javax.swing.JPopupMenu menuPop;
    private javax.swing.JMenu menuSalvar;
    private com.damage.frames.PanelDesenhaGrafo panelDesenha;
    // End of variables declaration//GEN-END:variables
}
