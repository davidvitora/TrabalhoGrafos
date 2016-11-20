package com.damage.grafos;

import com.damage.grafos.armazenamento.DefinicaoFormal;
import com.damage.grafos.armazenamento.Definicoes;
import com.damage.grafos.armazenamento.ListaDeAdjacencia;
import com.damage.grafos.armazenamento.MatrizAdjacencia;
import com.damage.grafos.armazenamento.MatrizIncidencia;
import com.damage.grafos.estruturasdedados.VectorAresta;
import com.damage.grafos.estruturasdedados.VectorNo;

public class Grafo {
    private String nome;
    private int[][] matrizI;
    private int[][] matrizA;
    private String Simples = "Não";
    private String Completo = "Não";
    private String Conexo = "Não";
    private String Planar = "Não";
    private String listaAdjacencia;
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
    
       public String getMatrizAdjacenciaString(){
        String stringMatrizAdjacencia = "";
        for(int i = 0; i < getNo().size(); i++){
            stringMatrizAdjacencia +=  "| ";
            for(int j = 0; j < getNo().size(); j++){
                stringMatrizAdjacencia += getMatrizA()[i][j] + " ";
            }
            stringMatrizAdjacencia += "| " + "\n";
        }
        return stringMatrizAdjacencia;
    }
    
    public String getMatrizIncidenciaString(){
        String stringMatrizIncidencia = "";
        if(this.getAresta().isEmpty()){
             stringMatrizIncidencia = "Não é possivel contruir a Matriz de Adjacência";
             return stringMatrizIncidencia;
        }
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
    
    //Rotina realizada sempre que a estrutura de um grafo é modificada para atualizar seus dados
    public void update(){
        this.getAresta().recalculate_index();
        this.getNo().recalculate_index();
        MatrizIncidencia.buildMatrizIncidenciaGrafo(this);
        MatrizAdjacencia.buildMatrizAdjacenciaGrafo(this);
        ListaDeAdjacencia.build(this);
        Definicoes def = new Definicoes();
        generateDefinicaoFormal();
        recalculaArestasDeNós();
        this.Simples = def .simples(this);
        this.Planar = def.planar(this);
        this.Completo = Definicoes.completo(this);
        this.Conexo = Definicoes.conexo(this);
    }
    
    //Gera a definicao formal de um grafo
    public void generateDefinicaoFormal(){
        String definicaoFormal = "G=({";
        for(int i = 0; i < this.no.size(); i++){
            definicaoFormal += this.no.getNo(i).getId();
            if(i + 1 < this.no.size()){
               definicaoFormal += ","; 
            }
        }
        definicaoFormal += "},{";
        for(int i = 0; i < this.aresta.size(); i++){
            definicaoFormal += this.aresta.getAresta(i).getId();
            if(i + 1 < this.aresta.size()){
               definicaoFormal += ","; 
            }
        }
        definicaoFormal += "},{";
        for(int i = 0; i < this.aresta.size(); i++){
            definicaoFormal += "g(" + this.aresta.getAresta(i).getId() + ")=("
                + this.aresta.getAresta(i).getNo1().getId() + "-" + this.aresta.getAresta(i).getNo2().getId() + ")";
            if(i + 1 < this.aresta.size()){
               definicaoFormal += ","; 
            }
        }
         definicaoFormal += "})";
         this.definicaoFormal = definicaoFormal;
    }
    
    //Utilizado no algoritimo de grafos planares
    public void resetaVisitas(){
        for (int i = 0; i < no.size(); i++){
            no.getNo(i).setVisitado(false);
        }
        for (int i = 0; i < aresta.size(); i++){
            aresta.getAresta(i).setVisitado(false);
        }    
    }
    
    //Recalcula as arestas presentes nas listas dos nós
    public void recalculaArestasDeNós(){
        //Limpa as arestas dos nos
        for(int i = 0; i < no.size(); i++){
            no.getNo(i).getArestas().clear();
        }
        //Coloca as arestas que pertencem a cada nó no conjunto
        for(int i = 0; i < no.size(); i++){
            for(int j = 0; j < aresta.size(); j++){
                if(aresta.getAresta(j).getNo1().equals(no.getNo(i))){
                    no.getNo(i).getArestas().add(aresta.getAresta(j));
                }
                if(aresta.getAresta(j).getNo2().equals(no.getNo(i))){
                    no.getNo(i).getArestas().add(aresta.getAresta(j));
                }
            }
        }
    }

    public String getListaAdjacencia() {
        return listaAdjacencia;
    }

    public void setListaAdjacencia(String listaAdjacencia) {
        this.listaAdjacencia = listaAdjacencia;
    }

    public String getSimples() {
        return Simples;
    }

    public void setSimples(String Simples) {
        this.Simples = Simples;
    }

    public String getCompleto() {
        return Completo;
    }

    public void setCompleto(String Completo) {
        this.Completo = Completo;
    }

    public String getConexo() {
        return Conexo;
    }

    public void setConexo(String Conexo) {
        this.Conexo = Conexo;
    }

    public String getPlanar() {
        return Planar;
    }

    public void setPlanar(String Planar) {
        this.Planar = Planar;
    }
    
}
