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

    // Asegurar que cada casilla esté inicializada
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            casillas[i][j] = new CasillaNormal(i, j); // Por defecto, todas las casillas son normales
        }
    }
}

    public void setCasilla(int x, int y, Casilla casilla) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            casillas[x][y] = casilla;
        }
    }

    public Casilla obtenerCasilla(int x, int y) {
        return casillas[x][y];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void definirCasillas(Scanner scanner) {
        System.out.println("Defina las casillas del mapa (N para normal, M para muro, E para enemigo):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Casilla (" + i + ", " + j + "): ");
                String tipo = scanner.nextLine().toUpperCase();
                switch (tipo) {
                    case "M":
                        casillas[i][j] = new CasillaMuro(i, j);
                        break;
                    case "E":
                        casillas[i][j] = new CasillaEnemigo(i, j);
                        break;
                    default:
                        casillas[i][j] = new CasillaNormal(i, j);
                }
            }
        }
    }

    public int getInicioX() {
        return 0; 
    }

    public int getInicioY() {
        return 0; 
    }
}
