/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.proyecto12025;

import com.marvp.personaje.Enemigo;
import com.marvp.personaje.Jugador;

/**
 *
 * @author paul_
 */
public class Combate {
    private Jugador jugador;
    private Enemigo enemigo;
    public Combate(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }
    public void iniciarCombate() { System.out.println("¡Combate iniciado!"); }
}
