package com.damage.grafos;


public class No {
    private int index;
    private Character id;
    
    public No(int index, Character id){
        this.index = index;
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int valor) {
        this.index = valor;
    }

    public Character getId() {
        return id;
    }

    public void setId(Character id) {
        this.id = id;
    }
}
