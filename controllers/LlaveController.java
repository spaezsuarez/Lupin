package controllers;

import models.Llave;

public class LlaveController {

    private Llave llave;

    public LlaveController() {
        
    }

    public Llave getLlave(){
        return this.llave;
    }

    public void setLlave(Llave llave) {
        this.llave = llave;
    }
    
}