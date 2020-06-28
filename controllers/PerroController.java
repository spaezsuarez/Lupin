package controllers;

import models.Lupin;
import models.Perro;
import controllers.abstracts.EnemigoController;

public class PerroController extends EnemigoController {

    public PerroController(Perro perro, Lupin lupin) {
        super(perro, lupin);
    }
    
}