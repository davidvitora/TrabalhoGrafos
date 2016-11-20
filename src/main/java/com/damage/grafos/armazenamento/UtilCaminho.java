/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.grafos.armazenamento;

import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.util.ContMaster;
import com.damage.util.Result;
import com.damage.util.ResultMaster;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author David .V
 */
public class UtilCaminho {
    
    //Funcao recursiva que tem por objetivo percorrer todos os possiveis caminhos a partir de um nó raiz
    public void menorCicloRe(No no, No noRaiz, ResultMaster resultMaster, Result result){
        No noaux = no;
        result.vetorNo.add(no);
        result.iteracoes++;
        for(int i = 0; i < no.getArestas().size(); i++){
            //Vai verificar se a aresta já está nas arestas do resultado, caso sim, será ignorada
            if(result.getVetorAresta().contains(no.getArestas().getAresta(i)) == false){
                //Adiciona o peso da aresta no contador do resultado e adiciona aresta nas arestas do resultado
                result.peso += no.getArestas().getAresta(i).getPeso();
                result.vetorAresta.add(no.getArestas().getAresta(i));
                if(no.getArestas().getAresta(i).getNo1().equals(no)){
                    no = no.getArestas().getAresta(i).getNo2();

                }else{
                    no = no.getArestas().getAresta(i).getNo1();
                }
                //Se o no atual equivale ao nó raiz, significa que o ciclo chegou ao fim e será adicionado na lista de resultados
                if(no.equals(noRaiz)){
                    resultMaster.getResultados().add(result);
                    break;
                }
                menorCicloRe(no,noRaiz,resultMaster, (Result) result.clone()); 
            }
            no = noaux;
        }
    }
    
    //Funcao modificada da anterior, ela só retornará um result com todos os nós e arestas obtidos durante a procura
    public Result CicloPegarApenasUmResult(No no, No noRaiz, Result result){
        No noaux = no;
        result.vetorNo.add(no);
        result.iteracoes++;
        for(int i = 0; i < no.getArestas().size(); i++){
            //Vai verificar se a aresta já está nas arestas do resultado, caso sim, será ignorada
            if(result.getVetorAresta().contains(no.getArestas().getAresta(i)) == false){
                //Adiciona o peso da aresta no contador do resultado e adiciona aresta nas arestas do resultado
                result.peso += no.getArestas().getAresta(i).getPeso();
                result.vetorAresta.add(no.getArestas().getAresta(i));
                if(no.getArestas().getAresta(i).getNo1().equals(no)){
                    no = no.getArestas().getAresta(i).getNo2();

                }else{
                    no = no.getArestas().getAresta(i).getNo1();
                }
                //Se o no atual equivale ao nó raiz, significa que o ciclo chegou ao fim e será adicionado na lista de resultados
                if(no.equals(noRaiz)){
                    break;
                }
                CicloPegarApenasUmResult(no,noRaiz, result); 
            }
            no = noaux;
        }
        return result;
    }
    
    public ResultMaster calcularCiclos(Grafo grafo){
        Vector<No> nos = grafo.getNo();
        No noRaiz;
        Result result = new Result();
        ResultMaster resultMaster = new ResultMaster();
        for (int i=0;i < nos.size();i++){
            noRaiz = nos.get(i);
            menorCicloRe( nos.get(i), noRaiz, resultMaster, result);
            grafo.resetaVisitas();
            result = new Result();
        }
        return resultMaster;
    }
    
    
    public String calcularCiclosToString(Grafo grafo){
        Vector<No> nos = grafo.getNo();
        No noRaiz;
        Result result = new Result();
        ResultMaster resultMaster = new ResultMaster();
        for (int i=0;i < nos.size();i++){
            noRaiz = nos.get(i);
            menorCicloRe( nos.get(i), noRaiz, resultMaster, result);
            grafo.resetaVisitas();
            result = new Result();
        }
        String resultados = "";
        for(int i = 0; i < resultMaster.getResultados().size(); i++){
            result = resultMaster.getResultados().get(i);
            resultados += result.ToStringCaminho() + "| Iterações: " + result.iteracoes + " | Peso: " + result.peso +"\n";  
        }
        return resultados;
    }
    
    public int calcularMenorCiclo(Grafo grafo){
        Vector<No> nos = grafo.getNo();
        No noRaiz;
        Result result = new Result();
        ResultMaster resultMaster = new ResultMaster();
        for (int i=0;i < nos.size();i++){
            noRaiz = nos.get(i);
            menorCicloRe( nos.get(i), noRaiz, resultMaster, result);
            result = new Result();
        }
        String resultados = "";
        int menorCiclo = 9999;
        System.out.println("size: " + resultMaster.getResultados().size());
        for(int i = 0; i < resultMaster.getResultados().size(); i++){
            result = resultMaster.getResultados().get(i);
            if(result.iteracoes < menorCiclo)
                menorCiclo = result.iteracoes;
        }
        return menorCiclo;
    }
    
    public  boolean verificarConexo(Grafo grafo){
        Vector<No> nos = grafo.getNo();  
        Result result = new Result();
        result = CicloPegarApenasUmResult( nos.get(0), nos.get(0), result);
        for(int i = 0; i < grafo.getNo().size(); i++){
            if(!result.getVetorNo().contains(grafo.getNo().getNo(i))){
                return false;
            }
        }
        return true;
    }
    
}
