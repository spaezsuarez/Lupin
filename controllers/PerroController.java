package lupin.controllers;

import lupin.models.Lupin;
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
        super.mover();
        this.perroGrafico.mover();
    }

}