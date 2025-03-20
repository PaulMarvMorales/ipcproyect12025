/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.proyecto12025;

import com.marvp.mapa.casilla.Casilla;
import com.marvp.mapa.casilla.CasillaEnemigo;
import com.marvp.mapa.casilla.CasillaMuro;
import com.marvp.mapa.casilla.CasillaNormal;
import com.marvp.personaje.Enemigo;
import com.marvp.personaje.Jugador;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author paul_
 */
public class Juego {
    private Mapa mapa;
    private Jugador jugador;
    private boolean estado;
    private Scanner scanner;
    private int movimientos;

    public Juego() {
        this.scanner = new Scanner(System.in);
        this.movimientos = 0;
    }

    public void menuPrincipal() {
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Reanudar partida");
            System.out.println("2. Iniciar nueva partida");
            System.out.println("3. Crear nuevo mapa");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    cargarPartida();
                    break;
                case 2:
                    seleccionarMapa();
                    iniciarJuego();
                    break;
                case 3:
                    mapa = crearMapa();
                    break;
                case 4:
                    System.out.println("Saliendo del juego...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public void iniciarJuego() {
        this.estado = true;
        this.movimientos = 0;
        this.jugador = new Jugador("Explorador", 100, 10, 0, 0);
        jugar();
    }

    public void jugar() {
        while (estado) {
            mostrarMapa();
            System.out.println("Ingrese movimiento (arriba, abajo, izquierda, derecha) o 'salir' para finalizar:");
            String input = scanner.nextLine().toLowerCase();
            
            if (input.equals("salir")) {
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                guardarPartida();
                estado = false;
                break;
            }
            
            int prevX = jugador.getX();
            int prevY = jugador.getY();
            jugador.mover(input, mapa.getFilas(), mapa.getColumnas());
            
            Casilla casillaActual = mapa.obtenerCasilla(jugador.getX(), jugador.getY());
            
            if (casillaActual instanceof CasillaMuro) {
                System.out.println("¡Es un muro! No puedes pasar.");
                jugador.setPosicion(prevX, prevY); // Mantiene la posición anterior
            } else if (casillaActual instanceof CasillaEnemigo) {
                Combate combate = new Combate(jugador, new Enemigo(50, 5));
                combate.iniciarCombate();
            }
            
            movimientos++;
        }
    }

    public void mostrarMapa() {
        for (int i = 0; i < mapa.getFilas(); i++) {
            for (int j = 0; j < mapa.getColumnas(); j++) {
                if (i == jugador.getX() && j == jugador.getY()) {
                    System.out.print("P ");
                } else {
                    System.out.print(mapa.obtenerCasilla(i, j).getSimbolo() + " ");
                }
            }
            System.out.println();
        }
    }

    public void seleccionarMapa() {
        mapa = new Mapa(10, 10);
    }

    public Mapa crearMapa() {
        return new Mapa(10, 10);
    }

    public void guardarPartida() {
        System.out.println("Partida guardada.");
    }

    public void cargarPartida() {
        System.out.println("Cargando partida...");
    }
}