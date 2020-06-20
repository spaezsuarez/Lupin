package models.Estados;

import models.abstracts.EstadoEnemigo;
import models.abstracts.Enemigo;


public class EnemigoDificil implements EstadoEnemigo {
    
    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    @Override
    public void perseguirJugador(){
        this.enemigo.setVelocidad(5);
    }
    
}