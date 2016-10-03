package com.damage.grafos;


public class No {
    private String id;
    private int index;
    
    public No(String id){
        this.id = id;
    }
    
    public No(String id, int index){
        this.id = id;
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
