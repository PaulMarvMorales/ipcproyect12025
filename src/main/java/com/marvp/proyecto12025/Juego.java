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
            System.out.println("4. Modificar mapa");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Salir");
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
                    crearMapa();
                    break;
                case 4:
                    modificarMapa();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
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
        this.jugador = new Jugador("Explorador", 100, 50, 10, 5, 0, 0);
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
            jugador.mover(input);
            
            Casilla casillaActual = mapa.obtenerCasilla(jugador.getX(), jugador.getY());
            
            if (casillaActual instanceof CasillaMuro) {
                System.out.println("¡Es un muro! No puedes pasar.");
                jugador.setPosicion(prevX, prevY); // Mantiene la posición anterior
            } else {
                movimientos++;
                casillaActual.activar(jugador);
            }
        }
    }

    public void mostrarMapa() {
        System.out.println("\n--- MAPA ---");
        for (int i = 0; i < mapa.getFilas(); i++) {
            for (int j = 0; j < mapa.getColumnas(); j++) {
                if (i == jugador.getX() && j == jugador.getY()) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Movimientos realizados: " + movimientos);
        System.out.println("HP del jugador: " + jugador.getHp());
        System.out.println("Ataque del jugador: " + jugador.getAtaque());
    }

    public void modificarMapa() {
        System.out.println("Ingrese la fila y columna de la casilla que desea modificar:");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        if (fila < 0 || fila >= mapa.getFilas() || columna < 0 || columna >= mapa.getColumnas()) {
            System.out.println("Posición fuera de los límites del mapa.");
            return;
        }
        
        System.out.println("Seleccione el nuevo tipo de casilla (N = Normal, M = Muro, E = Enemigo):");
        String tipo = scanner.nextLine().toUpperCase();
        
        switch (tipo) {
            case "M":
                mapa.setCasilla(fila, columna, new CasillaMuro(fila, columna));
                break;
            case "E":
                mapa.setCasilla(fila, columna, new CasillaEnemigo(fila, columna));
                break;
            default:
                mapa.setCasilla(fila, columna, new CasillaNormal(fila, columna));
        }
        
        System.out.println("Casilla modificada exitosamente.");
    }

    public void seleccionarMapa() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Usar mapa predeterminado");
        System.out.println("2. Crear un nuevo mapa");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        if (opcion == 2) {
            mapa = crearMapa();
        } else {
            mapa = new Mapa(10, 10);
        }
    }

    public Mapa crearMapa() {
        System.out.println("Ingrese el tamaño del mapa (filas columnas):");
        int filas = scanner.nextInt();
        int columnas = scanner.nextInt();
        scanner.nextLine();

        Mapa nuevoMapa = new Mapa(filas, columnas);
        System.out.println("Mapa creado con éxito.");
        return nuevoMapa;
    }
    
     public void guardarPartida() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("partida_guardada.txt"))) {
            writer.write(jugador.getX() + " " + jugador.getY() + "\n");
            writer.write(movimientos + "\n");
            System.out.println("Partida guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la partida.");
        }
    }

    public void cargarPartida() {
        try (BufferedReader reader = new BufferedReader(new FileReader("partida_guardada.txt"))) {
            String[] pos = reader.readLine().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            this.movimientos = Integer.parseInt(reader.readLine());
            this.jugador.setPosicion(x, y);
            System.out.println("Partida cargada exitosamente.");
            jugar();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar la partida. Se iniciará un nuevo juego.");
            seleccionarMapa();
            iniciarJuego();
        }
    }
}