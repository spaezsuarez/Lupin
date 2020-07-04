package lupin.models.Estados;

import lupin.models.abstracts.EstadoEnemigo;
import lupin.models.abstracts.Enemigo;

public class EnemigoFacil implements EstadoEnemigo {

    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    @Override
    public void perseguirJugador(){
        this.enemigo.setVelocidad(2);
    }
    
}