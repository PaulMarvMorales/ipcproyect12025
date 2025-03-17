/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Enemigo {
    private int hp = 50;
    private int ataque = 10;

    public int getHp() { return hp; }
    public int getAtaque() { return ataque; }
    public void recibirDano(int cantidad) { hp -= cantidad; }
}