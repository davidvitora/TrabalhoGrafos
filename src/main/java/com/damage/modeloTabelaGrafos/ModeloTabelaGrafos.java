/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.modeloTabelaGrafos;

import com.damage.grafos.Grafo;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;

/**
 *
 * @author David .V
 */
public class ModeloTabelaGrafos extends AbstractTableModel{
    
    private Vector<Grafo> grafos;
    String colunas[] = {"Nome","Nós","Arestas"};
    
    public ModeloTabelaGrafos(){
        this.grafos = new Vector<Grafo>();
    }

    
    public int getRowCount() {
        return getGrafos().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Grafo grafo= getGrafos().get(rowIndex);
         switch( columnIndex ) {
             case 0: return grafo.getNome();
             case 1: return grafo.getNo().size();
             case 2: return grafo.getAresta().size();
         }
         return null;
    }
    

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<Grafo> getGrafos() {
        return grafos;
    }

    public void setGrafos(Vector<Grafo> grafos) {
        this.grafos = grafos;
    }

}
