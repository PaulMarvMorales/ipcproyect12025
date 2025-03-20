/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.proyecto12025;

import com.marvp.mapa.casilla.Casilla;
import com.marvp.mapa.casilla.CasillaEnemigo;
import com.marvp.mapa.casilla.CasillaMuro;
import com.marvp.mapa.casilla.CasillaNormal;

import java.util.Scanner;

/**
 *
 * @author paul_
 */
public class Mapa {
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

    public Casilla obtenerCasilla(int x, int y) {
        return casillas[x][y];
    }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}