/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.modeloTabelaGrafos;

import com.damage.grafos.No;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David .V
 */
public class ModeloTabelaNo extends AbstractTableModel{
    
    private Vector<No> nos;
    String colunas[] = {"id"};
    
    public ModeloTabelaNo(Vector<No> nos){
        this.nos = nos;
    }

    
    public int getRowCount() {
        return getNos().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                 No no = nos.get(rowIndex);
         switch( columnIndex ) {
             case 0: return no.getId();
         }
         return null;
    }
    

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<No> getNos() {
        return nos;
    }

    public void setNos(Vector<No> nos) {
        this.nos = nos;
    }

}
