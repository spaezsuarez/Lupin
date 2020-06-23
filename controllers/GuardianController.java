package controllers;

import models.Guardian;

public class GuardianController {

    private Guardian guardian;

    public GuardianController() {
        
    }

    public Guardian getGuardian() {
        return this.guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

}