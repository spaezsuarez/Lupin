package lupin.models.Estados;

import lupin.models.abstracts.EstadoEnemigo;
import lupin.models.abstracts.Enemigo;


public class EnemigoDificil implements EstadoEnemigo {
    
    private Enemigo enemigo;

    @Override
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    @Override
    public void perseguirJugador(){
        this.enemigo.setVelocidad(this.enemigo.getVelocidad() + 1);
    }
    
}