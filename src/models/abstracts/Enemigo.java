package models.abstracts;

import models.Posicion;

public class Enemigo {

    private int velocidad;
    private Posicion posicion;
    private EstadoEnemigo estado;

    public Enemigo(double x,double y, int velocidad){
        this.posicion = new Posicion(x, y);
        this.velocidad = velocidad;
    }

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

    public void moverse(double x, double y){
        this.posicion.mover(this.posicion.getX() + x, this.posicion.getY() + y);
    }

    public void setEstado(EstadoEnemigo estado){
        this.estado = estado;
        this.estado.setEnemigo(this);
        this.estado.perseguirJugador();
    }
    
}