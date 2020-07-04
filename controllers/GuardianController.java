package lupin.controllers;

import lupin.models.Lupin;
import lupin.models.Perro;
import lupin.controllers.abstracts.EnemigoController;

public class GuardianController extends EnemigoController {

    public GuardianController(Perro guardian, Lupin lupin) {
        super(guardian, lupin);
    }
    
}