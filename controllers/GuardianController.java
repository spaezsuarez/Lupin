package lupin.controllers;

import lupin.controllers.abstracts.EnemigoController;
import lupin.models.Guardian;
import lupin.models.Lupin;

public class GuardianController extends EnemigoController{

    public GuardianController(Guardian guardian, Lupin lupin) {
        super(guardian, lupin);
    }

    @Override
    public void mover() {
    }
    
}