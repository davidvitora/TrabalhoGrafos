package com.damage.grafos.estruturasdedados;

import com.damage.grafos.Aresta;
import java.util.Vector;
import com.damage.grafos.No;

public class VectorAresta<No> extends Vector{
    public Aresta findById(String search){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            if(aresta.getId().equalsIgnoreCase(search)){
                return aresta;
            }
        }
        return null;
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
    
    public void print(){
        com.damage.grafos.Aresta aresta;
        for(int i = 0; i < this.size(); i++){
            aresta =  (com.damage.grafos.Aresta)this.get(i);
            System.out.println( "Aresta " + aresta.getId() + " Index " + i);
        }
    }
    
}
