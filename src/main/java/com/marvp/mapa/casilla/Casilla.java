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
public abstract class Casilla {
    protected int x, y;
    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract char getSimbolo();
}