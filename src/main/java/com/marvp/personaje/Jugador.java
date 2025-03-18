package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Jugador extends Personaje {

    private String nombre;
    private int hp, mp, ataque, defensa, x, y;

    public Jugador(String nombre, int hp, int mp, int ataque, int defensa, int x, int y) {
        super(hp, ataque);
        this.nombre = nombre;
        this.mp = mp;
        this.defensa = defensa;
        this.x = x;
        this.y = y;
    }

    

    public void mover(String direccion) {
        switch (direccion) {   // .toLowerCase()
            case "W" -> {
                if (x > 0) {
                    x--;
                }
            }
            case "S" -> {
                if (x < 9) {
                    x++;
                }
            }
            case "A" -> {
                if (y > 0) {
                    y--;
                }
            }
            case "D" -> {
                if (y < 9) {
                    y++;
                }
            }
        }
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }
    
    public String getNombre(){
        return nombre;
    }

    @Override
    public int getAtacar() {
        return ataque;
    }
    
    @Override
    public void recibirDanio(int cantidad) {
        this.hp = hp - cantidad;
        System.out.println("Has recibido " + cantidad + " de daño. HP restante: " + this.hp);
        if (this.hp <= 0) {
            System.out.println("Has sido derrotado.");
        }
    }
}
