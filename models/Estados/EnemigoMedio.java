package lupin.models.Estados;

import lupin.models.abstracts.Enemigo;
import lupin.models.abstracts.EstadoEnemigo;

public class EnemigoMedio implements EstadoEnemigo {

    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    @Override
    public void perseguirJugador(){
        this.enemigo.setVelocidad(this.enemigo.getVelocidad() + 3);
    }
    
}