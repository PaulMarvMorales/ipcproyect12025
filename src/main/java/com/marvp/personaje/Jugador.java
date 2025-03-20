package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Jugador {
    private int hp, ataque, x, y;

    public Jugador(String nombre, int hp, int ataque, int x, int y) {
        this.hp = hp;
        this.ataque = ataque;
        this.x = x;
        this.y = y;
    }

    public void mover(String direccion, int maxFilas, int maxColumnas) {
        switch (direccion) {
            case "arriba": if (x > 0) x--; break;
            case "abajo": if (x < maxFilas - 1) x++; break;
            case "izquierda": if (y > 0) y--; break;
            case "derecha": if (y < maxColumnas - 1) y++; break;
        }
    }

    public void setPosicion(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
}