package com.damage.grafos.armazenamento;

import com.damage.Response.Response;
import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;
import java.util.Iterator;
import java.util.Vector;


public class MatrizAdjacencia {
    
    public static Response buildMatrizAdjacenciaGrafo(Grafo grafo){
        Aresta aresta;
        Response response = new Response();
        int[][] matrizA = new int[grafo.getNo().size()][grafo.getNo().size()];;
        if(grafo.getAresta() == null || grafo.getNo() == null){
            response.setCode(400);
            response.setMessage("Não é possivel montar a Matriz de Adjacência pois o grafo não possui Nós e Arestas");
            return response;
        }
        
        for(int i =0;i<grafo.getAresta().size();i++)
        {
            aresta = (Aresta) grafo.getAresta().get(i);
            for(int j =0; j<grafo.getNo().size();j++)
            {
                if(grafo.getNo().getNo(j)==aresta.getNo1())
                {
                    matrizA[aresta.getNo1().getIndex()][aresta.getNo2().getIndex()] = 1;
                    matrizA[aresta.getNo2().getIndex()][aresta.getNo1().getIndex()] = 1;
                }
            }
        }
        
        response.setCode(200);
        response.setMessage("Matriz de Adjacência criada com sucesso");
        grafo.setMatrizA(matrizA);
        return response;
    }
}

