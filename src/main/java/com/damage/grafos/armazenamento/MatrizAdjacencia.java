package com.damage.grafos.armazenamento;

public class MatrizAdjacencia {

 public int[][] getMatrizAdjacencia(String definicaoFormal) // nao liguem para meus erros de portuga(meu teaclado nao tema cento e a versao pt-br do windowns buga com ele, entao tudo ta sem acento), esta foi a maneira mais facil e mais rapida que pensei em fazer entao ta ai.
 {
     try{
   char[] defineFormal; // cria um vetor de char.
   defineFormal = definicaoFormal.toCharArray(); //O mesmo vetor de char recebe a definicao formal dividida em varias partes, infelismente nao pode haver espaco na definicao formal, caso queiram que teje espacos eu cuido disso.
   char[] vetores; // chiado outro vetor de char, porem este para receber os vetores colocados, como a matriz de adjacencia tem a mesma quantia de vetores e arestas nao tem a necessidade de colocar outro vetor de char para arestas.
   vetores = getValores(4, defineFormal, '}'); //chama a funcao get valores, onde eu passo o valor o inicializador e o finalizador e no meio a minha definicao formal.
   int[][] posicoes = new int[vetores.length][vetores.length]; //este cara identifica as posicoes, ou seja, este e a matriz completa.

   for (int i = 0; i < vetores.length; i++) //percorre apenas os tres valores do vetor
   {
    for (int j = 0; j < defineFormal.length; j++) //cada valor do vetor percorre em toda a minha definicao formal para entao descobrir onde ta.
    {
     if (defineFormal[j] == vetores[i] && defineFormal[j - 2] == '=') //como a definicao formal e totalmente padrao, eu defini ps valores po posicoes dos mesmo, sendo que desta forma fica muito mais rapido.
     {
      posicoes[i][getPosicao(vetores, defineFormal[j + 2])] = 1; //aqui e onde atribui 1 onde existe ligacoes.
     }
    }
   }

   print(posicoes, vetores.length); //apenas para testes, ele pinta toda a  matriz.


   return posicoes; //retorna a matriz.
  }
     catch(ArrayIndexOutOfBoundsException  e)
     {
         System.out.println("Erro caracter: " + e);
     }
     return null;
 }

 public void print(int[][] posicoes, int repete) //como o nome diz ele print a ,matriz
  {
   for (int k = 0; k < repete; k++) //Print Teste
   {
    for (int l = 0; l < repete; l++) {
     System.out.print(posicoes[k][l] + " ");
    }
    System.out.println("\n");
   }

  }

 public int getPosicao(char[] itens, char comparar) // for que verifica qual posicao o simbolo representado pelo vetor esta. 
  {
   for (int i = 0; i < itens.length; i++) {
    if (itens[i] == comparar)
     return i;
   }
   return 0;
  }

 public int getQuantia(int inicial, char[] valor, char diferente) //retorna a quantia de vetores que existem.
  {
   int quantia = 0;
   while (valor[inicial] != diferente) {
    if (valor[inicial] != ',') {
     quantia++;
    }
    inicial++;
   }
   return quantia;
  }
 public char[] getValores(int inicial, char[] valor, char diferente) {
  char[] valores = new char[getQuantia(inicial, valor, diferente)]; //cria-se um vetores de char novamente onde este estara os valores de meus vetores, podendo ser usado tambem para arestas.
  int i = 0;
  while (valor[inicial] != diferente) //while que indetifica que gira enquanto o valor que e minha deifnicao formal estiver na posicao diferente do meu individuo final.
  {
   if (valor[inicial] != ',') //tudo que nao for ',' ele adiciona ao valor.
   {
    valores[i] = valor[inicial];
    i++;
   }
   inicial++;
  }
  return valores; //retorna o vetor.
 }

}