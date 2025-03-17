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
public class CasillaTrampa extends Casilla {
    private int dano;
    public CasillaTrampa(int x, int y, int dano) {
        super(x, y);
        this.tipo = "Trampa";
        this.dano = dano;
    }
    public void activar(Jugador jugador) {
        jugador.recibirDano(dano);
        System.out.println("¡Pisas una trampa! Pierdes " + dano + " puntos de vida.");
    }
}
