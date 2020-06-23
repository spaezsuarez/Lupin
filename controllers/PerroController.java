package controllers;

import models.Perro;

public class PerroController {

    private Perro perro;

    public PerroController() {
        
    }

    public Perro getPerro() {
        return this.perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }
    
}