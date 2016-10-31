package com.damage.grafos;


public class No {

    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public void setCordenadaY(int cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    public int getCordenadaX() {
        return cordenadaX;
    }

    public int getCordenadaY() {
        return cordenadaY;
    }
    private String id;
    private int index;
    private int cordenadaX;
    private int cordenadaY;
    
    public No(String id){
        this.id = id;
    }
    
    public No(){
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
