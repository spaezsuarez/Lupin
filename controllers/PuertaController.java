package controllers;

import models.Puerta;
import models.Llave;

public class PuertaController {

    private Puerta puerta;

    public PuertaController() {
        
    }

    public void abrir(Llave llave){
        if(llave != null){
            //TODO:ELIMINAR EL OBJETO
        }
    }

    public Puerta getPuerta() {
        return this.puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }
    
}