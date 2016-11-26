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
    
    //Algoritomo para criar a lista de adjacencia, como parâmetro o grafo é enviado para a função
    public static void build(Grafo grafo){
        String listaAdjacencia = "";
        No no;
        Aresta aresta;
        //Percorrerá todos os nós do grafo
        for(int i = 0; i < grafo.getNo().size(); i++){
            no = grafo.getNo().getNo(i);
            listaAdjacencia += "|" + no.getId() + "|";
            //percorrá todas as arestas do nó atual
            for(int j = 0; j < no.getArestas().size(); j++){
                aresta = no.getArestas().getAresta(j);
                //Caso o no1 da aresta seja o nó atual, será colocada na lista o nó 2
                if(aresta.getNo1().equals(no)){
                    listaAdjacencia += " -> |";
                    listaAdjacencia += aresta.getNo2().getId() + "|";
                }
                //Caso o no2 da aresta seja o nó atual, será colocada na lista o nó1
                else if(aresta.getNo2().equals(no)){
                    listaAdjacencia += " -> |";
                    listaAdjacencia += aresta.getNo1().getId() + "|";
                }
            }
            listaAdjacencia += "\n\n";
        }
        //O texto de lista de adjacencia do grafo será definido como o criado com o algoritimo
        grafo.setListaAdjacencia(listaAdjacencia);
    }
    
}
