package lupin.controllers;

import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.controllers.abstracts.EnemigoController;

public class GuardianController extends EnemigoController {

    public GuardianController(Guardian guardian, Lupin lupin) {
        super(guardian, lupin);
    }
    
}