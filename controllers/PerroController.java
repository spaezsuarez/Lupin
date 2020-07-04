package controllers;

import models.Lupin;
import models.Perro;
import models.abstracts.Enemigo;
import controllers.abstracts.EnemigoController;

public class PerroController extends EnemigoController {

    public PerroController(Enemigo perro, Lupin lupin) {
        super(perro, lupin);
    }

    @Override
    public Perro getEnemigo(){
        return (Perro)this.getEnemigo();
    }

}