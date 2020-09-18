package controllers.abstracts;

import models.Lupin;
import models.Posicion;
import models.abstracts.Enemigo;
import views.abstracts.Personaje;

public class EnemigoController {

    private Enemigo enemigo;
    private Lupin lupin;
    private Personaje enemigoGrafico;

    public EnemigoController(Enemigo enemigo, Lupin lupin) {
        this.enemigo = enemigo;
        this.lupin = lupin;
    }

    public void mover() {
        Posicion posicion = new Posicion(0,0);
        posicion.mover(this.lupin.getPosicion().getX() - this.enemigo.getPosicion().getX(), this.lupin.getPosicion().getY() - this.enemigo.getPosicion().getY());
        double magnitud = Math.sqrt(Math.pow(posicion.getX(), 2) + Math.pow(posicion.getY(), 2));
        posicion.mover((posicion.getX() / magnitud), (posicion.getY() / magnitud));
        posicion.mover(enemigo.getVelocidad() * posicion.getX(), enemigo.getVelocidad() * posicion.getY());
        mover(posicion.getX(), posicion.getY());
    }

    public void mover(double x, double y) {
        this.enemigo.moverse(x, y);
        this.enemigoGrafico.mover();
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

    public void setEnemigoGrafico(Personaje enemigoGrafico) {
        this.enemigoGrafico = enemigoGrafico;
    }

    public Personaje getEnemigoGrafico() {
        return enemigoGrafico;
    }
    
}