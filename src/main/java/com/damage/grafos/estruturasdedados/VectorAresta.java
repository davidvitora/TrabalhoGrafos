package com.damage.grafos.estruturasdedados;

import com.damage.grafos.Aresta;
import java.util.Vector;
import com.damage.grafos.No;

public class VectorAresta<Aresta> extends Vector{
    public Aresta findById(String search){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            if(aresta.getId().equalsIgnoreCase(search)){
                return (Aresta) aresta;
            }
        }
        return null;
    }
    
    public Aresta getAresta(int index){
        return (Aresta) this.get(index);
    }
    
    public boolean possuiAresta(No no){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            if(aresta.getNo1().equals(no) || aresta.getNo2().equals(no)){
                return true;
            }
        }
        return false;
    }
    
    public int findIndexById(String search){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            if(aresta.getId().equalsIgnoreCase(search)){
                return i;
            }
        }
        return -1;
    }
    
    public void recalculate_index(){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            aresta.setIndex(i);
        }
    }
    
    public void print(){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            System.out.println( "Aresta " + aresta.getId() + " Index " + i);
        }
    }
    
}
