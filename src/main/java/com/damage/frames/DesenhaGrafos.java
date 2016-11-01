
package com.damage.frames;

import com.damage.grafos.Aresta;
import com.damage.grafos.No;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.atan2;
import java.util.ArrayList;

/**
 *
 * @author Marlon
 */
public class DesenhaGrafos extends javax.swing.JFrame {
private boolean novo = false, selecionado = false, selecionadoVermelho=false;
int eixoX,eixoY, indexNo=-1, indexAresta=-1;  
ArrayList<Aresta> aresta = new ArrayList();
ArrayList<No> no = new ArrayList();
No no1, no2;

    public DesenhaGrafos() {
       
        initComponents();
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNovo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jMenu1.setText("Arquivo");

        menuNovo.setText("Novo");
        menuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNovo);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoActionPerformed
        novo=true;
    }//GEN-LAST:event_menuNovoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           
        this.dispose(); 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void paint(Graphics g)
    {
        if(novo)
        {
        if(selecionado)
        {
            if(no1!=null&&no2!=null)
            {
                if(no1.getCordenadaX()==no2.getCordenadaX()&&no1.getCordenadaY()==no2.getCordenadaY())
                {  
                    g.setColor(Color.green);
                    g.drawOval(no1.getCordenadaX()-10, no2.getCordenadaY()-10, 25, 25);
                    selecionado=false;
                    this.repaint();
                }
                
                else{
                    g.setColor(Color.blue);
                    g.drawLine(no1.getCordenadaX()+10, no1.getCordenadaY()+10, no2.getCordenadaX()+10, no2.getCordenadaY()+10);
                    g.setColor(Color.black);
                    g.fillOval(no1.getCordenadaX(), no1.getCordenadaY(), 20,20);
                    g.fillOval(no2.getCordenadaX(), no2.getCordenadaY(), 20,20);
                    
          
                     
                     
                    selecionado=false;
                    no1=null;
                    no2=null;
                }
            }
            else
            {
            g.setColor(Color.red);
            g.fillOval(no1.getCordenadaX(), no1.getCordenadaY(), 20,20);
            selecionadoVermelho=true;
            }
            
        }
        else if(!no.isEmpty()&&!selecionadoVermelho)
        {
            g.fillOval(no.get(indexNo).getCordenadaX(), no.get(indexNo).getCordenadaY(), 20,20);
            g.setColor(Color.blue);
            g.drawString(no.get(indexNo).getId(), no.get(indexNo).getCordenadaX()+20, no.get(indexNo).getCordenadaY()+20);
        }
        else
        {
            g.setColor(Color.black);
             g.fillOval(no1.getCordenadaX(), no1.getCordenadaY(), 20,20);
             no1=null;
             no2=null;
             selecionadoVermelho=false;
        }
        
    }
    }        
    
 
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        if(novo)
        {
            
            if(selecionado)
            {  no2 = getNo(evt.getX(),evt.getY());
               Aresta arestaNova = new Aresta();
                if(no2!=null)
                {
                    arestaNova.setNo1(no1);
                    arestaNova.setNo2(no2);
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
                selecionadoVermelho=false;
                No noAdd = new No();
                noAdd.setCordenadaX(evt.getX()-10);
                noAdd.setCordenadaY(evt.getY()-10);
                indexNo++;
                noAdd.setId(Integer.toString(indexNo));
                noAdd.setIndex(no.size());
                no.add(noAdd);
             }
             else
                 selecionado=true;
            }
           this.repaint(); 
        }
        
    }//GEN-LAST:event_formMouseClicked

   public No getNo(int getX, int getY)
   {
        for(No n:no)
            {
                if(getX<=n.getCordenadaX()+20&&getX>=n.getCordenadaX()-20&&getY<=n.getCordenadaY()+20&&getY>=n.getCordenadaY()-20)
                {return n;}
            }
        return null;
   }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuNovo;
    // End of variables declaration//GEN-END:variables
}
