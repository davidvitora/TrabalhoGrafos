package com.damage.grafos;

import com.damage.grafos.armazenamento.DefinicaoFormal;
import com.damage.grafos.armazenamento.MatrizIncidencia;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;

public class Grafo {
    private int[][] matrizI;
    private int[][] matrizA;
    private VectorNo<No> no = null;
    private VectorAresta<Aresta> aresta = null;
    
    public Grafo(String definicaoFormal){
        System.out.println(DefinicaoFormal.build(definicaoFormal, this).getMessage());
        System.out.println(MatrizIncidencia.buildMatrizIncidenciaDigrafo(this));
    }
    
    public Grafo(){}
    
    public void printMatrizIncidencia(){
        System.out.println("");
        for(int i = 0; i < getNo().size(); i++){
            System.out.print("|  ");
            for(int j = 0; j < getAresta().size(); j++){
                System.out.print(getMatrizI()[i][j] + "\t");
            }
            System.out.println("  |");
        }
    }

    public VectorNo<No> getNo() {
        return no;
    }

    public void setNo(VectorNo<No> no) {
        this.no = no;
    }

    public VectorAresta<Aresta> getAresta() {
        return aresta;
    }

    public void setAresta(VectorAresta<Aresta> aresta) {
        this.aresta = aresta;
    }

    public int[][] getMatrizI() {
        return matrizI;
    }

    public void setMatrizI(int[][] matrizI) {
        this.matrizI = matrizI;
    }

    public int[][] getMatrizA() {
        return matrizA;
    }

    public void setMatrizA(int[][] matrizA) {
        this.matrizA = matrizA;
    }
    
}
