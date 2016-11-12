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
import com.damage.util.ContMaster;
import java.util.Vector;

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
    
    public void menorCicloRe(No no, No noRaiz, ContMaster contMaster, int cont){
        for(int i = 0; i < no.getArestas().size(); i++){
            if(no.getArestas().getAresta(i).getVisitado() == false){
                if(no.getArestas().getAresta(i).getNo2().equals(no.getArestas().getAresta(i).getNo1())){
                    contMaster.setContMaster(1);
                    //
                    return;
                }
                if(no.getArestas().getAresta(i).getNo1().equals(no)){
                    no.getArestas().getAresta(i).setVisitado(true);
                    no = no.getArestas().getAresta(i).getNo2();
                    if(no.getVisitado() == true){
                        continue;
                    }
                    no.setVisitado(true);
                }else{
                    no.getArestas().getAresta(i).setVisitado(true);
                    no = no.getArestas().getAresta(i).getNo1();
                    if(no.getVisitado() == true){
                        continue;
                    }
                    no.setVisitado(true);
                }
                cont++;
                if(cont > contMaster.getContMaster()){
                    continue;
                }
                if(no.equals(noRaiz)){
                    if(contMaster.getContMaster() > cont)
                    contMaster.setContMaster(cont);
                    break;
                }
                menorCicloRe(no,noRaiz,contMaster,cont);
                
            }
        }
    }
    
    public String planar(Grafo grafo){
        Vector<No> nos = grafo.getNo();
        No noRaiz;
        Aresta aresta;
        No noAtual;
        int cont = 0;
        ContMaster contMaster = new ContMaster(999);
        for (int i=0;i<nos.size();i++){
            noRaiz = nos.get(i);
            menorCicloRe(nos.get(i),noRaiz,contMaster,cont);
            grafo.resetaVisitas();  
        }
        System.out.println(contMaster.getContMaster());
        if (contMaster.getContMaster() > 2){
            if (grafo.getAresta().size() <= 2*(grafo.getNo().size()) - 4){
                return "Sim"; 
            }
            else return "Não";
        }
        else if(grafo.getAresta().size() <= 3*(grafo.getNo().size()) - 6){
            return "Sim";
        }
        else return "Não"; 
    }
    
    public static  String conexo(Grafo grafo){
        return "Conexo";
    }
    
}
