package controllers.abstracts;

import models.Lupin;
import models.Posicion;
import models.abstracts.Enemigo;

public abstract class EnemigoController {

    private Enemigo enemigo;
    private Lupin lupin;

    public EnemigoController(Enemigo enemigo, Lupin lupin) {
        this.enemigo = enemigo;
        this.lupin = lupin;
    }

    public void mover() {
        Posicion posicion = new Posicion();
        posicion.mover(this.lupin.getPosicion().getX() - this.enemigo.getPosicion().getX(), this.lupin.getPosicion().getY() - this.enemigo.getPosicion().getY());
        double magnitud = Math.sqrt(Math.pow(posicion.getX(), 2) + Math.pow(posicion.getY(), 2));
        posicion.mover((int)(posicion.getX() / magnitud), (int)(posicion.getY() / magnitud));
        this.enemigo.moverse(this.enemigo.getVelocidad() * (this.enemigo.getPosicion().getX() + posicion.getX()), this.enemigo.getVelocidad() * (this.enemigo.getPosicion().getY() + posicion.getY()));
    }

    public Enemigo getEnemigo() {
        return this.enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public Lupin getLupin() {
        return this.lupin;
    }

    public void setLupin(Lupin lupin) {
        this.lupin = lupin;
    }
    
}