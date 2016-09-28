package com.damage.grafos.armazenamento;

import com.damage.grafos.Aresta;
import com.damage.grafos.No;
import java.util.Vector;


public class MatrizIncidencia {
    
    public static int[][] build(String definicaoFormal){
        int[][] matrizA;
        Vector<No> no = null;
        Vector<Aresta> aresta = null;
        int posAtual = 0;
        definicaoFormal = definicaoFormal.toLowerCase();
        char letra = ' ';
        if(definicaoFormal.substring(0, 3) == "g=({"){
            letra = definicaoFormal.charAt(posAtual);
            for(posAtual = 4; letra != '}'; posAtual++){
                no.add(new No( posAtual, letra ));
                posAtual++;
                if(definicaoFormal.charAt(posAtual) != ',' || definicaoFormal.charAt(posAtual) != '}'){
                    exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    return null;
                }
                letra = definicaoFormal.charAt(posAtual);
            }
            posAtual++;
            if(definicaoFormal.charAt(posAtual) != ','){
                exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                return null;
            }
            for(posAtual++; letra != '}'; posAtual++){
                aresta.add(new Aresta(posAtual, definicaoFormal.charAt(posAtual)));
                posAtual++;
                if(definicaoFormal.charAt(posAtual) != ',' || definicaoFormal.charAt(posAtual) != '}'){
                    exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    return null;
                }
                letra = definicaoFormal.charAt(posAtual);
            }
            posAtual++;
            if(definicaoFormal.charAt(posAtual) != ','){
                exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                return null;
            }
            matrizA = new int[no.size()][aresta.size()];
            posAtual++;
            for(posAtual++; letra != '}'; posAtual++){
                posAtual++;
                posAtual++;
                posAtual++;
                posAtual++;
                posAtual++;
                
                
                
                
                
                
                
                posAtual++;
                if(definicaoFormal.charAt(posAtual) != ',' || definicaoFormal.charAt(posAtual) != '}'){
                    exceptionCNE(',', definicaoFormal.charAt(posAtual), posAtual);
                    return null;
                }
                letra = definicaoFormal.charAt(posAtual);
            }
        }
        return null;
    }
    
    public static void exceptionCNE(char esperado, char recebido, int index){
        System.out.println("Erro no caracter de numero" + 
                       index + "/ Esperado " + esperado +" recebido " + recebido);
        
    }
}
