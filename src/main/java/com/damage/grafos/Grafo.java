package com.damage.grafos;

import com.damage.grafos.armazenamento.DefinicaoFormal;
import com.damage.grafos.armazenamento.MatrizIncidencia;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;

public class Grafo {
    private String nome;
    private int[][] matrizI;
    private int[][] matrizA;
    private VectorNo<No> no = null;
    private VectorAresta<Aresta> aresta = null;
    private String definicaoFormal;
    
    public Grafo(String definicaoFormal){
        System.out.println(DefinicaoFormal.build(definicaoFormal, this).getMessage());
        System.out.println(MatrizIncidencia.buildMatrizIncidenciaGrafo(this).getMessage());
    }
    
    public Grafo(){
        no = new VectorNo<No>();
        aresta = new VectorAresta<Aresta>();
    }
    
    public String getMatrizIncidenciaString(){
        String stringMatrizIncidencia = "";
        for(int i = 0; i < getNo().size(); i++){
            stringMatrizIncidencia +=  "| ";
            for(int j = 0; j < getAresta().size(); j++){
                stringMatrizIncidencia += getMatrizI()[i][j] + " ";
            }
            stringMatrizIncidencia += "| " + "\n";
        }
        return stringMatrizIncidencia;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDefinicaoFormal() {
        return definicaoFormal;
    }

    public void setDefinicaoFormal(String definicaoFormal) {
        this.definicaoFormal = definicaoFormal;
    }
    
}
