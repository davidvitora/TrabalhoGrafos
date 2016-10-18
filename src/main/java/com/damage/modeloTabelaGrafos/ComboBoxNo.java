package com.damage.modeloTabelaGrafos;

import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorNo;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;


public class ComboBoxNo extends AbstractListModel implements ComboBoxModel{

    public VectorNo<No> nos;
    String listaNos[];
    private  No selectedNo;

    public ComboBoxNo(VectorNo<No> nos){
        this.nos = nos;
        listaNos = new String[nos.size()];
        for(int i = 0; i < nos.size(); i++){
            listaNos[i] = nos.getNo(i).getId();
        }
        this.selectedNo = (No) this.nos.get(0);
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedNo = this.nos.findById((String) anItem);
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedNo.getId();
    }
    
    public No getSelectedNo() {
        return this.selectedNo;
    }

    @Override
    public int getSize() {
        return this.nos.size();
    }

    @Override
    public Object getElementAt(int index) {
       return listaNos[index];
    }
    
}
