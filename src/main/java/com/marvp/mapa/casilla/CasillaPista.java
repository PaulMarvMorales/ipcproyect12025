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
public class CasillaPista extends Casilla {
    private String pista;
    public CasillaPista(int x, int y, String pista) {
        super(x, y);
        this.tipo = "Pista";
        this.pista = pista;
    }
    public void activar(Jugador jugador) {
        System.out.println("Pista: " + pista);
    }
}
