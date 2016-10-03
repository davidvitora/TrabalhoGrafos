package com.damage.grafos;

public class Aresta {
    private String id;
    private int index;
    private No origem;
    private No destino;
    
    public Aresta(String id){
        this.id = id;
    }
    
    public Aresta(String id, int index){
        this.id = id;
        this.index = index;
    }
    
    public boolean isDefined(){
        if(getOrigem() != null && getDestino() != null){
            return true;
        }
        return false;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public No getOrigem() {
        return origem;
    }

    public void setOrigem(No origem) {
        this.origem = origem;
    }

    public No getDestino() {
        return destino;
    }

    public void setDestino(No destino) {
        this.destino = destino;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
