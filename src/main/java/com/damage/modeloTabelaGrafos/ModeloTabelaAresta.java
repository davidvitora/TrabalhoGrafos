/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.modeloTabelaGrafos;

import com.damage.grafos.Aresta;
import com.damage.grafos.estruturasdedados.VectorAresta;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David .V
 */
public class ModeloTabelaAresta extends AbstractTableModel{
    
    private VectorAresta<Aresta> arestas;
    String colunas[] = {"Id","Nó","Nó"};
    
    public ModeloTabelaAresta(VectorAresta<Aresta> arestas){
        this.arestas = arestas;
    }

    
    public int getRowCount() {
        return getArestas().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Aresta aresta = (Aresta) getArestas().get(rowIndex);
         switch( columnIndex ) {
             case 0: return aresta.getId();
             case 1: return aresta.getNo1().getId();
             case 2: return aresta.getNo2().getId();
         }
         return null;
    }
    

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public VectorAresta<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(VectorAresta<Aresta> arestas) {
        this.arestas = arestas;
    }

}
