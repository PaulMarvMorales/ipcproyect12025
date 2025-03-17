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
public class CasillaEnemigo extends Casilla {
    public CasillaEnemigo(int x, int y) {
        super(x, y);
        this.tipo = "Enemigo";
    }
    public void activar(Jugador jugador) {
        System.out.println("¡Un enemigo aparece!");
    }
}