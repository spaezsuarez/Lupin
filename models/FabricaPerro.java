package models;

import models.abstracts.Enemigo;
import models.abstracts.FabricaEnemigo;

public class FabricaPerro implements FabricaEnemigo {

    @Override
    public Enemigo crearEnemigos(){

        return new Enemigo();
    }
    
}