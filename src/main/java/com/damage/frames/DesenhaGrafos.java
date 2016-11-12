
package com.damage.frames;

import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;
import com.damage.modeloTabelaGrafos.ModeloTabelaGrafos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.atan2;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon
 */
public class DesenhaGrafos extends javax.swing.JFrame {
private boolean selecionado = false, selecionadoVermelho=false;
private int eixoX,eixoY, indexNo=-1, indexAresta=-1, divisor =1;  
private VectorAresta<Aresta> aresta = new VectorAresta();
private VectorNo<No> no = new VectorNo();
private No no1, no2;
private Aresta arestaNova = new Aresta();
private Graphics2D bkp;
private Graphics2D g = (Graphics2D) this.getGraphics();
ModeloTabelaGrafos modelo;

    public DesenhaGrafos() {
       
        initComponents();
    }
    
    public DesenhaGrafos(ModeloTabelaGrafos modelo) {
        this.modelo = modelo;
        initComponents();
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuSalvar = new javax.swing.JMenu();
        menuGravar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

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
            .addGap(0, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(766, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGravarActionPerformed
     this.setVisible(false);
     String nome = "";
     while( nome.length() < 1)
      {
          nome = JOptionPane.showInputDialog(null, "Digite um nome: ", "Nome", 1);
      }    
      
      Grafo grafo = new Grafo();
      grafo.setNome(nome);
      grafo.setAresta(aresta);
      grafo.setNo(no);
      grafo.update();
      modelo.getGrafos().add(grafo);
      modelo.fireTableDataChanged();
            
    }//GEN-LAST:event_menuGravarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           
        this.dispose(); 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
      
    public void AbrirGrafo(Grafo grafo, Graphics2D gra, boolean preVisualiza)
    {  
        if(gra == null)
            gra=(Graphics2D) this.getGraphics();
        
         divisor = preVisualiza ? 2 :1;
        
         g=gra;
        for(int i =0; i<grafo.getNo().size(); i++)
        {
            no.add(grafo.getNo().getNo(i));
            indexNo++;
            DesenhaVetor();
        }
        
        for(int i =0; i<grafo.getAresta().size(); i++)
        {
            arestaNova=grafo.getAresta().getAresta(i);
            aresta.add(arestaNova);
            no1=arestaNova.getNo1();
            no2=arestaNova.getNo2();
            DesenhaAresta(false);
        }
        bkp = g;
    }
    
    public Graphics2D repaintBKP()
    {
        return bkp;
    }        
    
    public void DesenhaParalelo(int contPara)
    {
         
            CubicCurve2D quadCurve = new CubicCurve2D.Double(no1.getCordenadaX()+10, no1.getCordenadaY()+10, no1.getCordenadaX()-15-contPara*35,no1.getCordenadaY()-15-contPara*35, no2.getCordenadaX()-15-contPara*35, no2.getCordenadaY()-15-contPara*35, no2.getCordenadaX()+10, no2.getCordenadaY()+10);
            g.draw(quadCurve);
            
    }       
    
    public void DesenhaLaco(int contLaco)
    {
        
            g.setColor(Color.green);
            g.drawOval(no1.getCordenadaX()-10-contLaco*10, no1.getCordenadaY()-10-contLaco*10, 25+(contLaco*10), 25+(contLaco*10));
            selecionado=false;
    }
    
    public void DesenhaAresta(boolean caminho)
    {       
            if(VerificaParalelo())
            {
                DesenhaParalelo(arestaNova.getContParalelo());
            }
            else
            {
            g.setColor(caminho ? Color.red : Color.blue);
            g.drawLine((no1.getCordenadaX()+10)/divisor, (no1.getCordenadaY()+10)/divisor, (no2.getCordenadaX()+10)/divisor, (no2.getCordenadaY()+10)/divisor);
            g.setColor(Color.black);
            g.fillOval(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor, 20,20);
            g.fillOval(no2.getCordenadaX()/divisor, no2.getCordenadaY()/divisor, 20,20);
            }
            selecionado=false;
            DesenhaSelecionado();
            no1=null;
            no2=null;
    }
    
    public void DesenhaSelecionado()
    {       
            if(selecionado)
            {
            g.setColor(Color.red);
            g.fillOval(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor, 20,20);
            selecionadoVermelho=true;
            }
            else
            {
             g.setColor(Color.black);
             g.fillOval(no1.getCordenadaX()/divisor, no1.getCordenadaY()/divisor, 20,20);
             no1=null;
             no2=null;
             selecionadoVermelho=false;
            }
    }
    
    public void DesenhaVetor()
    {
            g.fillOval(no.getNo(indexNo).getCordenadaX()/divisor, no.getNo(indexNo).getCordenadaY()/divisor, 20,20);
            g.setColor(Color.MAGENTA);
            g.drawString(no.getNo(indexNo).getId(), no.getNo(indexNo).getCordenadaX()/divisor + 20, no.getNo(indexNo).getCordenadaY()/divisor+20);
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
        g = (Graphics2D) this.getGraphics();
        
        
        if(selecionado)
        { 
       
            if(no1!=null&&no2!=null)
            {
                
                if(no1.getCordenadaX()==no2.getCordenadaX()&&no1.getCordenadaY()==no2.getCordenadaY())
                {  
                   DesenhaLaco(arestaNova.getContLaco());
                   selecionado = false;
                   DesenhaSelecionado();
                }
                else 
                {
                    DesenhaAresta(false); 
                }
            }
            else
            {
            DesenhaSelecionado();
            }
            
        }
        else if(!no.isEmpty()&&!selecionadoVermelho)
        {
            DesenhaVetor();
        }
        else
        {
             DesenhaSelecionado();
          
        }
        
        
    }
    
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        arestaNova = new Aresta();
            if(selecionado)
            {  no2 = getNo(evt.getX(),evt.getY());
                if(no2!=null)
                {
                    arestaNova.setNo1(no1);
                    arestaNova.setNo2(no2);
                    if(no1==no2)
                    {
                        arestaNova.setContLaco(GetLaco()+1);
                    }
                    
                    indexAresta++;
                    arestaNova.setId(Integer.toString(indexAresta));
                    arestaNova.setIndex(indexAresta);
                    aresta.add(arestaNova);
                    
                }
                else
                    selecionado=false;
            }
            else
            {
             no1 = getNo(evt.getX(),evt.getY());
             if(no1==null)
             {
                if(evt.getX()>25&&evt.getX()<750&&evt.getY()>100&&evt.getY()<630)
                {
                selecionadoVermelho=false;
                No noAdd = new No();
                noAdd.setCordenadaX(evt.getX()-10);
                noAdd.setCordenadaY(evt.getY()-10);
                indexNo++;
                noAdd.setId(Integer.toString(indexNo));
                noAdd.setIndex(no.size());
                no.add(noAdd);
                }
                
             }
             else
                 selecionado=true;
            }
           VerificaDesenho(); 
        
        
    }//GEN-LAST:event_formMouseClicked

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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuGravar;
    private javax.swing.JMenu menuSalvar;
    // End of variables declaration//GEN-END:variables
}
