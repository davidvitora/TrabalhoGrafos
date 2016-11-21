package com.damage.grafos;

public class Aresta {
    private String id;
    private int index;
    private No no1;
    private No no2;
    private boolean visitado = false;
    private int contLaco=0;
    private int contParalelo=0;
    

        public void setContLaco(int contLaco) {
            this.contLaco = contLaco;
        }

        public void setContParalelo(int contParalelo) {
            this.contParalelo = contParalelo;
        }

        public int getContLaco() {
            return contLaco;
        }

        public int getContParalelo() {
            return contParalelo;
        }
    
    public Aresta(String id){
        this.id = id;
    }
    
    public Aresta(){
    }
    
    public Aresta(String id, int index){
        this.id = id;
        this.index = index;
    }
    
    public boolean isDefined(){
        if(getNo1() != null && getNo2() != null){
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



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public No getNo1() {
        return no1;
    }

    public void setNo1(No no1) {
        this.no1 = no1;
    }

    public No getNo2() {
        return no2;
    }

    public void setNo2(No no2) {
        this.no2 = no2;
    }
    
    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }
    public boolean getVisitado(){
        return visitado;
    }
}
