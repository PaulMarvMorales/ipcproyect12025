/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.mapa;

import com.marvp.mapa.casilla.Casilla;
import com.marvp.mapa.casilla.CasillaNormal;
import com.marvp.personaje.Jugador;

/**
 *
 * @author paul_
 */
class Mapa {
    private int filas;
    private int columnas;
    private Casilla[][] casillas;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new CasillaNormal(i, j);
            }
        }
    }

    public void mostrarMapa(Jugador jugador) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == jugador.getX() && j == jugador.getY()) {
                    System.out.print("^ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
