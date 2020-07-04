package lupin.controllers.abstracts;

import lupin.models.Lupin;
import lupin.models.Posicion;
import lupin.models.abstracts.Enemigo;

public abstract class EnemigoController {

    private Enemigo enemigo;
    private Lupin lupin;

    public EnemigoController(Enemigo enemigo, Lupin lupin) {
        this.enemigo = enemigo;
        this.lupin = lupin;
    }

    public void mover() {
        Posicion posicion = new Posicion(0,0);
        posicion.mover(this.lupin.getPosicion().getX() - this.enemigo.getPosicion().getX(), this.lupin.getPosicion().getY() - this.enemigo.getPosicion().getY());
        double magnitud = Math.sqrt(Math.pow(posicion.getX(), 2) + Math.pow(posicion.getY(), 2));
        posicion.mover((posicion.getX() / magnitud), (posicion.getY() / magnitud));
        this.enemigo.moverse(posicion.getX(), posicion.getY());
    }

    public void mover(int x, int y) {
        double xi = this.enemigo.getPosicion().getX();
        double yi = this.enemigo.getPosicion().getY();
        this.enemigo.getPosicion().mover(xi + x, yi + y);
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