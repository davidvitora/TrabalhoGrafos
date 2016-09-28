package com.damage.grafos;

public class Aresta {
    private int index;
    private Character id;
    private No origem;
    private No destino;
    
    public Aresta(int index, Character id){
        this.id = id;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Character getId() {
        return id;
    }

    public void setId(Character id) {
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
}
