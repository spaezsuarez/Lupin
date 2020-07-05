package lupin.controllers;

import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.views.GuardianGrafico;
import lupin.controllers.abstracts.EnemigoController;

public class GuardianController extends EnemigoController {

    private GuardianGrafico guardianGrafico;

    public GuardianController(Guardian guardian, Lupin lupin) {
        super(guardian, lupin);
    }

    public void setGuardianGrafico(GuardianGrafico guardianGrafico) {
        this.guardianGrafico = guardianGrafico;
    }

    public GuardianGrafico getGuardianGrafico() {
        return guardianGrafico;
    }

    @Override
    public void mover() {
        super.mover();
        guardianGrafico.mover();
    }
    
}