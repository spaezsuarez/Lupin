package controllers;

import models.Lupin;
import models.Perro;
import models.Posicion;
import java.lang.Math;

public class PerroController {

    private Perro perro;
    private Lupin lupin;

    public PerroController(Perro perro, Lupin lupin) {
        this.perro = perro;
        this.lupin = lupin;
    }

    public void mover() {
        Posicion posicion = new Posicion();
        posicion.mover(this.lupin.getPosicion().getX() - this.perro.getPosicion().getX(), this.lupin.getPosicion().getY() - this.perro.getPosicion().getY());
        double magnitud = Math.sqrt(Math.pow(posicion.getX(), 2) + Math.pow(posicion.getY(), 2));
        posicion.mover((int)(posicion.getX() / magnitud), (int)(posicion.getY() / magnitud));
        this.perro.moverse(this.perro.getVelocidad() * (this.perro.getPosicion().getX() + posicion.getX()), this.perro.getVelocidad() * (this.perro.getPosicion().getY() + posicion.getY()));
    }

    public Perro getPerro() {
        return this.perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Lupin getLupin() {
        return this.lupin;
    }

    public void setLupin(Lupin lupin) {
        this.lupin = lupin;
    }
    
}