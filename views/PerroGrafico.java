package lupin.views;

import lupin.controllers.abstracts.EnemigoController;
import lupin.views.abstracts.Personaje;

public class PerroGrafico extends Personaje {

    private static final long serialVersionUID = 1L;
    private EnemigoController enemigo;

    public PerroGrafico(EnemigoController enemigo,Jugador jugador){
        this.setSize(60, 30);
        this.setText("Perro");
        this.enemigo = enemigo;
        this.setLocation((int)this.enemigo.getEnemigo().getPosicion().getX(), (int)this.enemigo.getEnemigo().getPosicion().getY());
    }

    public EnemigoController getPerroController(){
        return this.enemigo;
    }

    @Override
    public void mover() {
        this.setLocation((int)this.enemigo.getEnemigo().getPosicion().getX(), (int)this.enemigo.getEnemigo().getPosicion().getY());
    }

    @Override
    public void mover(int x, int y) {
        this.enemigo.mover(x, y);

    }
    
}