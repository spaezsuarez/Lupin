package controllers;

import models.Puerta;
import models.Llave;
import models.Posicion;

public class PuertaController {

    private Puerta puerta;

    public PuertaController(Posicion posicion, String password) {
        puerta = new Puerta(posicion, password);
    }

    public void abrir(Llave llave){
        if((llave != null) && (llave.getPassword().equals(this.puerta.getPassword()))){
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