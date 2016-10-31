/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.grafos.armazenamento;

import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;

/**
 *
 * @author David .V
 */
public class ListaDeAdjacencia {
    
    public static void build(Grafo grafo){
        String listaAdjacencia = "";
        No no;
        Aresta aresta;
        for(int i = 0; i < grafo.getNo().size(); i++){
            no = grafo.getNo().getNo(i);
            listaAdjacencia += "|" + no.getId() + "|";
            for(int j = 0; j < grafo.getAresta().size(); j++){
                aresta = grafo.getAresta().getAresta(j);
                if(aresta.getNo1().equals(no)){
                    listaAdjacencia += " -> |";
                    listaAdjacencia += aresta.getNo2().getId() + "|";
                }else if(aresta.getNo2().equals(no)){
                    listaAdjacencia += " -> |";
                    listaAdjacencia += aresta.getNo1().getId() + "|";
                }
            }
            listaAdjacencia += "\n\n";
        }
        grafo.setListaAdjacencia(listaAdjacencia);
    }
    
}
