package models.abstracts;

import models.Posicion;

public class Enemigo {

    private int velocidad;
    private Posicion posicion;

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public int getVelocidad(){
        return this.velocidad;
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void moverse(int x, int y){
        this.posicion.mover(x, y);

    }
    
}