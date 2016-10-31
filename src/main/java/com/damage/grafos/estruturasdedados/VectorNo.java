package com.damage.grafos.estruturasdedados;

import java.util.Vector;
import com.damage.grafos.No;

public class VectorNo<No> extends Vector{
    public No findById(String search){
        com.damage.grafos.No no;
        for(int i = 0; i < this.size(); i++){
            no =  (com.damage.grafos.No)this.get(i);
            if(no.getId().equalsIgnoreCase(search)){
                return (No) no;
            }
        }
        return null;
    }
    
    public No getNo(int index){
        return (No) this.get(index);
    }
    
    public int findIndexById(String search){
        com.damage.grafos.No no;
        for(int i = 0; i < this.size(); i++){
            no =  (com.damage.grafos.No)this.get(i);
            if(no.getId().equalsIgnoreCase(search)){
                return i;
            }
        }
        return -1;
    }
    
    public void recalculate_index(){
        com.damage.grafos.No no;
        for(int i = 0; i < this.size(); i++){
            no =  (com.damage.grafos.No)this.get(i);
            no.setIndex(i);
        }
    }
    
    public void print(){
        com.damage.grafos.No no;
        for(int i = 0; i < this.size(); i++){
            no =  (com.damage.grafos.No)this.get(i);
            System.out.println( "No " + no.getId() + " Index " + i);
        }
    }
}
