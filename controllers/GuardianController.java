package controllers;

import models.Lupin;
import models.Perro;
import controllers.abstracts.EnemigoController;

public class GuardianController extends EnemigoController {

    public GuardianController(Perro guardian, Lupin lupin) {
        super(guardian, lupin);
    }
    
}