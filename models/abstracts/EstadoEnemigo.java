package models.abstracts;

import models.Lupin;

public interface EstadoEnemigo {

    public void setEnemigo(Enemigo enemigo);

    public void perseguirJugador(Lupin lupin); 
    
}