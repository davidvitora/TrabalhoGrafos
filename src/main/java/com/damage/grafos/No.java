package com.damage.grafos;

import java.util.Vector;
import com.damage.grafos.estruturasdedados.VectorAresta;


public class No {
    private String id;
    private int index;
<<<<<<< HEAD
    private VectorAresta<Aresta> arestas = new VectorAresta();
    private boolean visitado = false;
    
=======

    private int cordenadaX;
    private int cordenadaY;
    private VectorAresta<Aresta> arestas = new VectorAresta();
    private boolean visitado = false;
    
    public int getCordenadaX() {
        return cordenadaX;
    }

    public int getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public void setCordenadaY(int cordenadaY) {
        this.cordenadaY = cordenadaY;
    }
    
>>>>>>> refs/remotes/origin/Marlon
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

    public VectorAresta<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(VectorAresta<Aresta> arestas) {
        this.arestas = arestas;
    }
    
    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }
    public boolean getVisitado(){
        return visitado;
    }
}
