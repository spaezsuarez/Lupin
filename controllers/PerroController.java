package lupin.controllers;

import lupin.models.Lupin;
import lupin.models.Posicion;
import lupin.models.abstracts.Enemigo;
import lupin.views.PerroGrafico;
import lupin.controllers.abstracts.EnemigoController;

public class PerroController extends EnemigoController {

    private PerroGrafico perroGrafico;

    public PerroController(Enemigo perro, Lupin lupin) {
        super(perro, lupin);
    }

    public void setPerroGrafico(PerroGrafico perroGrafico) {
        this.perroGrafico = perroGrafico;
    }

    public PerroGrafico getPerroGrafico() {
        return perroGrafico;
    }

    @Override
    public void mover() {
        Posicion posicion = new Posicion(0,0);
        posicion.mover(this.getLupin().getPosicion().getX() - this.getEnemigo().getPosicion().getX(), this.getLupin().getPosicion().getY() - this.getEnemigo().getPosicion().getY());
        double magnitud = Math.sqrt(Math.pow(posicion.getX(), 2) + Math.pow(posicion.getY(), 2));
        posicion.mover((posicion.getX() / magnitud), (posicion.getY() / magnitud));
        this.getEnemigo().moverse(posicion.getX(), posicion.getY());
        this.perroGrafico.mover();
    }

}