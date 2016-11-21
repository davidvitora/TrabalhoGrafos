
package com.damage.grafos.estruturasdedados;

import com.damage.grafos.Grafo;


public class FuncoesDesenho
{
    public int getNumeroRamdomX()
    {
        return (int) (Math.random() * (750 - 50) + 50);
    }
    public int getNumeroRamdomY()
    {
        return (int) (Math.random() * (600 - 100) + 100);
    }
    
    public Grafo verificaLaco(Grafo grafo)
     {
         int contLaco  = 0;
         for(int i = 0 ;i < grafo.getAresta().size() ; i++)
         {
             if(grafo.getAresta().getAresta(i).getNo1().getIndex()==grafo.getAresta().getAresta(i).getNo2().getIndex())
             {
                 contLaco++;
                 grafo.getAresta().getAresta(i).setContLaco(contLaco);
             }   
         }
         return grafo;
     }
}
