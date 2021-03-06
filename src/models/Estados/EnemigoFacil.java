package models.Estados;

import models.abstracts.EstadoEnemigo;
import models.abstracts.Enemigo;

public class EnemigoFacil implements EstadoEnemigo {

    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    @Override
    public void perseguirJugador(){
        this.enemigo.setVelocidad(this.enemigo.getVelocidad() -2);
    }
    
}