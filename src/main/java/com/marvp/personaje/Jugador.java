/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Jugador {
    private String nombre;
    private int hp, mp, ataque, defensa, x, y;
    
    public Jugador(String nombre, int hp, int mp, int ataque, int defensa, int x, int y) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.x = x;
        this.y = y;
    }
    
    public void recibirDano(int cantidad) {
        this.hp -= cantidad;
        System.out.println("Has recibido " + cantidad + " de daño. HP restante: " + this.hp);
        if (this.hp <= 0) {
            System.out.println("Has sido derrotado.");
        }
    }
    
    public void mover(String direccion) {
        switch (direccion.toLowerCase()) {
            case "arriba": if (x > 0) x--; break;
            case "abajo": if (x < 9) x++; break;
            case "izquierda": if (y > 0) y--; break;
            case "derecha": if (y < 9) y++; break;
        }
    }
    
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() { return hp; }
    public int getAtaque() { return ataque; }
}