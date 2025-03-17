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
public class CasillaNormal extends Casilla {

    private final String tipo;
    public CasillaNormal(int x, int y) {
        super(x,y);
        this.tipo = "Normal";
    }
    public void activar(Jugador jugador) {
        // No hace nada especial
    }
}
