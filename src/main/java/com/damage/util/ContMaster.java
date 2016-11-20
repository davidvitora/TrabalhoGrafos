/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damage.util;

import com.damage.grafos.Aresta;
import java.util.Vector;

/**
 *
 * @author David .V
 */
public class ContMaster {
    private int contMaster;
    private Vector<Aresta> vetorMaster;
    
    public ContMaster(int cont){
        this.contMaster = cont;
    }

    public int getContMaster() {
        return contMaster;
    }

    public void setContMaster(int contMaster) {
        this.contMaster = contMaster;
    }

    public Vector<Aresta> getVetorMaster() {
        return vetorMaster;
    }

    public void setVetorMaster(Vector<Aresta> vetorMaster) {
        this.vetorMaster = vetorMaster;
    }
    
}
