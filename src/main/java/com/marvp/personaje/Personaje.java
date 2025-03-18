/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvp.personaje;

/**
 *
 * @author paul_
 */
public class Personaje {
    int hp;
    int ataque;
    
    public Personaje(int hp, int ataque){
        this.hp = hp;
        this.ataque = ataque;
    }
    
    public int getAtacar(){
        return 0;
    }
    public void recibirDanio(int cantidad){
        System.out.println("Recibe daño");
    }
}
