package com.damage.grafos.armazenamento;

import com.damage.Response.Response;
import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;
import java.util.Iterator;
import java.util.Vector;


public class MatrizIncidencia {
    
    public static Response buildMatrizIncidenciaGrafo(Grafo grafo){
        Aresta aresta;
        Response response = new Response();
        int[][] matrizI;
        if(grafo.getAresta() == null || grafo.getNo() == null){
            response.setCode(400);
            response.setMessage("Não é possivel montar a Matriz de incidencia pois o grafo não possui Nós e Arestas");
            return response;
        }
        matrizI = new int[grafo.getNo().size()][grafo.getAresta().size()];
        
        for(int i = 0; i < grafo.getAresta().size(); i++){
            aresta = grafo.getAresta().getAresta(i);
            matrizI[aresta.getNo1().getIndex()][i] += 1;
            if(aresta.getNo1().getIndex() == aresta.getNo2().getIndex()){
                continue;
            }
            matrizI[aresta.getNo2().getIndex()][i] += 1;
        }
        
        response.setCode(200);
        response.setMessage("Matriz de incidência criada com sucesso");
        grafo.setMatrizI(matrizI);
        return response;
    }
}

