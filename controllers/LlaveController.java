package controllers;

import models.Llave;
import models.Posicion;

public class LlaveController {

    private Llave llave;

    public LlaveController(Posicion posicion, String password) {
        llave = new Llave(posicion, password);
    }

    public Llave getLlave(){
        return this.llave;
    }

    public void setLlave(Llave llave) {
        this.llave = llave;
    }
    
}