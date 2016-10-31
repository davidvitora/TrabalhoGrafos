package com.damage.grafos.armazenamento;

import com.damage.Response.Response;
import com.damage.grafos.Aresta;
import com.damage.grafos.Grafo;
import com.damage.grafos.No;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;


public class DefinicaoFormal {
    
    /** Recebe uma definicao formal e um grafo, pega a definição formal 
     * e costroi os nós e arestas no grafo enviado
     * @param definicaoFormal string da definicao formal para ser convertida
     * @param grafo grafo que terá os nós e arestas 
     * @return retorna a resposta da conversão com um codigo 200 = sucesso , 400 = erro*/
    public static Response build(String definicaoFormal, Grafo grafo){
        definicaoFormal = definicaoFormal.replaceAll(" ", "");
        Aresta aresta;
        int index = 0;
        VectorNo<No> no = new VectorNo();
        VectorAresta<Aresta> arestas = new VectorAresta();
        int posAtual = 0;
        char letra;
        String id;
        Response response = new Response();
        try{
            if(definicaoFormal.substring(0, 4).equalsIgnoreCase("G=({")){
                letra = definicaoFormal.charAt(posAtual);
                for(posAtual = 4; letra != '}'; posAtual++){
                    for(id = ""; definicaoFormal.charAt(posAtual) != ',' && definicaoFormal.charAt(posAtual) != '}'; posAtual++){
                        id = id + definicaoFormal.charAt(posAtual);
                    }
                    if(id.equalsIgnoreCase("")){
                        return exceptionDNE(" g(NOMEDAARESTA)=(NÓ,NÓ) ", posAtual);
                    }
                    if(no.findById(id) != null){
                        return exceptionNoJaCriado(id,posAtual);
                    }
                    no.add(new No(id, index));
                    if(definicaoFormal.substring(posAtual,posAtual).equalsIgnoreCase(",") || definicaoFormal.substring(posAtual,posAtual).equalsIgnoreCase("}")){
                        return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    }
                    letra = definicaoFormal.charAt(posAtual);
                    index++;
                }
                if(definicaoFormal.charAt(posAtual) != ','){
                    return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                }
                posAtual += 2;
                index = 0;
                for(letra = ' '; letra != '}'; posAtual++ ){
                    for(id = ""; definicaoFormal.charAt(posAtual) != ',' && definicaoFormal.charAt(posAtual) != '}'; posAtual++){
                        id = id + definicaoFormal.charAt(posAtual);
                    }
                    if(id.equalsIgnoreCase("")){
                        return exceptionDNE(" g(NOMEDAARESTA)=(NÓ,NÓ) ", posAtual);
                    }
                    if(arestas.findById(id) != null){
                        return exceptionArestaJaCriada(id,posAtual);
                    }
                    arestas.add(new Aresta(id, index));
                    if(definicaoFormal.charAt(posAtual) != ',' && definicaoFormal.charAt(posAtual) != '}'){
                        return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    }
                    letra = definicaoFormal.charAt(posAtual);
                    index++;
                }
                if(definicaoFormal.charAt(posAtual) != ','){
                    return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                }
                posAtual += 2;
                for(letra = ' '; letra != '}'; posAtual++){
                    if(!definicaoFormal.substring(posAtual, posAtual + 2).equalsIgnoreCase("g(")){
                        return exceptionDNE(" g(NOMEDAARESTA)=(NÓ,NÓ) ", posAtual);
                    }
                    posAtual += 2;
                    for(id = ""; definicaoFormal.charAt(posAtual) != ')'; posAtual++){
                        id = id + definicaoFormal.charAt(posAtual);
                    }
                    if(id.equalsIgnoreCase("")){
                        return exceptionDNE(" g(NOMEDAARESTA)=(NÓ,NÓ) ", posAtual);
                    }
                    aresta = arestas.findById(id);
                    if(aresta == null){
                        return exceptionArestaNaoCriada(id,posAtual);
                    }
                    if(aresta.getNo1() != null && aresta.getNo2() != null){
                        return exceptionArestaJaDefinida(id,posAtual);
                    }
                    if(!definicaoFormal.substring(posAtual, posAtual + 3).equalsIgnoreCase(")=(")){
                        return exceptionDNE(" g(NOMEDAARESTA)=(NÓ,NÓ) ", posAtual);
                    }
                    posAtual += 3;
                    for(id = ""; definicaoFormal.charAt(posAtual) != '-'; posAtual++){
                        id = id + definicaoFormal.charAt(posAtual);
                    }
                    if(no.findById(id) == null){
                        return exceptionNoNaoCriado(id,posAtual);
                    }
                    aresta.setNo1(no.findById(id));
                    if(definicaoFormal.charAt(posAtual) != '-'){
                        return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    }
                    posAtual++;
                    for(id = ""; definicaoFormal.charAt(posAtual) != ')'; posAtual++){
                        id = id + definicaoFormal.charAt(posAtual);
                    }
                    if(no.findById(id) == null){
                        return exceptionNoNaoCriado(id,posAtual);
                    }
                    aresta.setNo2(no.findById(id));
                    posAtual++;
                    if(definicaoFormal.charAt(posAtual) != ',' && definicaoFormal.charAt(posAtual) != '}'){
                        return exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    }
                    letra = definicaoFormal.charAt(posAtual);
                }
                if(definicaoFormal.charAt(posAtual) != ')'){
                    return exceptionCNE(')', definicaoFormal.charAt(posAtual), posAtual);
                }
                grafo.setDefinicaoFormal(definicaoFormal);
                grafo.setAresta(arestas);
                grafo.setNo(no);
                response.setCode(200);
                response.setMessage("Matriz de incidencia criada com sucesso");
                return response;
            }else{
                response.setCode(400);
                response.setMessage("Não foi possivelvel criar grafo, verifique a definiçao");
            }
        }catch(Exception e){
            response.setCode(400);
            response.setMessage("Não foi possivelvel criar grafo, verifique a definiçao");
        }
        return response;
    }
    
    public static Response exceptionCNE(char esperado, char recebido, int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Erro no caracter de numero " + 
                       index + " - Esperado " + esperado +" recebido " + recebido);
        return response;
    }
    
    public static Response exceptionDNE(String esperado,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Erro na definicao com caracter de numero " + 
                       index + " - Esperado modelo de definição de aresta" + esperado);
        return response;
    }
    
    public static Response exceptionArestaJaCriada(String id,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Duplicidade nos dados - Caracter " + 
                       index + " - A resta " + id + " já foi criada");
        return response;
    }
    
    public static Response exceptionArestaJaDefinida(String id,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Duplicidade nos dados - Caracter " + 
                       index + " - A resta " + id + " já foi definida");
        return response;
    }
    
    public static Response exceptionArestaNaoCriada(String id,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Problema na definicao - Caracter " + 
                       index + " - A resta " + id + " não foi criada");
        return response;
    }
    
    public static Response exceptionNoNaoCriado(String id,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Problema na definicao - Caracter " + 
                       index + " - O no " + id + " não foi criado");
        return response;
    }
    
    public static Response exceptionNoJaCriado(String id,int index){
        Response response = new Response();
        response.setCode(400);
        response.setMessage("Duplicidade nos dados - Caracter " + 
                       index + " - O No " + id + " já foi criado");
        return response;
    }
}

