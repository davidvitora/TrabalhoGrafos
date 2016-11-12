
package com.damage.grafos.estruturasdedados;


public class GeraPosicoesRamdomicas
{
    public int getNumeroRamdomX()
    {
        return (int) (Math.random() * (750 - 50) + 50);
    }
    public int getNumeroRamdomY()
    {
        return (int) (Math.random() * (600 - 100) + 100);
    }
}
