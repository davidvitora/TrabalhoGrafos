/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.grafos.armazenamento;

import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorNo;

/**
 *
 * @author David .V
 */
public class Definicoes {
    
    public static String completo(Grafo grafo){
        No no;
        VectorNo<No> nos;
        
        if(!simples(grafo).equalsIgnoreCase("Sim")){
            return "Não";
        }
        for(int i = 0; i < grafo.getNo().size(); i++){
            nos = new VectorNo();
            no  = grafo.getNo().getNo(i);
            for(int j = 0; j < grafo.getAresta().size(); j++){
                   if(grafo.getAresta().getAresta(j).getNo1().equals(no)){
                       nos.add(grafo.getAresta().getAresta(j).getNo2());
                   }else if(grafo.getAresta().getAresta(j).getNo2().equals(no)){
                       nos.add(grafo.getAresta().getAresta(j).getNo1());
                   }
            }
            for(int j = 0; j < grafo.getNo().size(); j++){
                if(j == i){
                    continue;
                }
                if(!nos.contains(grafo.getNo().getNo(j))){
                    return "Não";
                }
            }
        }
       
    return "Sim";
    }
    
    public static String simples(Grafo grafo){
        boolean simples = true;
        Aresta aresta;
        No no, noVerifica;
        VectorNo<No> nos;
        
        for(int i = 0; i < grafo.getAresta().size(); i++){
            aresta = (Aresta) grafo.getAresta().get(i);
            if(aresta.getNo1().equals(aresta.getNo2())){
                return "Não";
            }
        }
        
        for(int i = 0; i < grafo.getNo().size(); i++){
            nos = new VectorNo();
            no  = grafo.getNo().getNo(i);
            for(int j = 0; j < grafo.getAresta().size(); j++){
                if(grafo.getAresta().getAresta(j).getNo1().equals(no)){
                    nos.add(grafo.getAresta().getAresta(j).getNo2());
                }
                
            }
            
            for(int j = 0; j < grafo.getAresta().size(); j++){
                if(grafo.getAresta().getAresta(j).getNo2().equals(no)){
                    nos.add(grafo.getAresta().getAresta(j).getNo1());
                }
                
            }
            
            for(int j = 0; j < nos.size(); j++){
                System.out.println(nos.getNo(j).getId());
            }
            
            System.out.println("----------");
            
            for(int j = 0; j < nos.size(); j++){
                for(int l = j + 1; l < nos.size(); l++){
                    if(nos.getNo(j).equals(nos.getNo(l))){
                        return "Não";
                    }
                }
            }
            
            
        }
        
        return "Sim";
    }
    
    public static  String planar(Grafo grafo){
        return "Planar";
    }
    
    public static  String conexo(Grafo grafo){
        return "Conexo";
    }
    
}
