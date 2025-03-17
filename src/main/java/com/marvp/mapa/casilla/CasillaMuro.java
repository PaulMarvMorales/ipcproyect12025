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
public class CasillaMuro extends Casilla {
    public CasillaMuro(int x, int y) {
        super(x, y);
        this.tipo = "Muro";
    }
    public void activar(Jugador jugador) {
        System.out.println("¡Es un muro! No puedes pasar.");
    }
}