package models;

import models.abstracts.FabricaEnemigo;

public class FabricaPerro implements FabricaEnemigo {

    @Override
    public Perro crearEnemigos(){

        return new Perro(10,25, 1);
    }
    
}