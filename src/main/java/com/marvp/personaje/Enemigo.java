/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Enemigo extends Personaje {

    public Enemigo() {
        super(25, 5);
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int getAtacar() {
        return ataque;
    }
    
    
    @Override
    public void recibirDanio(int cantidad) {
        hp -= cantidad;
    }
}
