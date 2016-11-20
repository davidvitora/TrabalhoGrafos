/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.util;

//Essa classe se refere a um caminho verificado

import com.damage.grafos.Aresta;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;
import java.util.Vector;

public class Result{
    int id = 0;
    String veio = "";
    public VectorAresta<Aresta> vetorAresta;
    public VectorNo<No> vetorNo;
    public int peso;
    public int iteracoes;
    
    public Result(){
        vetorAresta = new VectorAresta<Aresta>();
        vetorNo = new VectorNo<No>();
    }
    
    public Object clone(){
        Result result = new Result();
        result.setVetorAresta((VectorAresta<Aresta>) vetorAresta.clone());
        result.setPeso(peso);
        result.setVetorNo((VectorNo<No>) vetorNo.clone());
        result.setIteracoes(iteracoes);
        result.veio = "Veio do result " + id;
        return result;
    }

    public VectorAresta<Aresta> getVetorAresta() {
        return vetorAresta;
    }

    public void setVetorAresta(VectorAresta<Aresta> vetorAresta) {
        this.vetorAresta = vetorAresta;
    }

    public VectorNo<No> getVetorNo() {
        return vetorNo;
    }

    public void setVetorNo(VectorNo<No> vetorNo) {
        this.vetorNo = vetorNo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIteracoes() {
        return iteracoes;
    }

    public void setIteracoes(int iteracoes) {
        this.iteracoes = iteracoes;
    }
    
    public String ToStringCaminho(){
        String caminho = "";
        for(int i = 0; i < vetorNo.size(); i++){
            caminho += vetorNo.getNo(i).getId() + ", ";
            if( i < vetorAresta.size() ){
                caminho += vetorAresta.getAresta(i).getId() + ", ";
            }
        }
        caminho += vetorNo.getNo(0).getId();
        return caminho;
    }
}
