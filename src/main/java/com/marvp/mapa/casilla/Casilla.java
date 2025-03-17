/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.mapa.casilla;

import com.marvp.personaje.Jugador;

/**
 *
 * @author paul_
 */
public class Casilla {
    protected String tipo;
    protected int x, y;

    public String getTipo() {
        return tipo;
    }
    
    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public  void activar(Jugador jugador){
        System.out.println(""); // hace algo en cada casilla
    }
}
