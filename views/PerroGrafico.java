package views;

import controllers.PerroController;
import views.abstracts.Personaje;

public class PerroGrafico extends Personaje {

    private static final long serialVersionUID = 1L;
    private PerroController enemigo;

    public PerroGrafico(PerroController enemigo,Jugador jugador){
        this.setSize(40, 30);
        this.setText("enemigo");
        this.enemigo = enemigo;
        this.setLocation(this.enemigo.getEnemigo().getPosicion().getX(), this.enemigo.getEnemigo().getPosicion().getY());
    }

    public PerroController getPerroController(){
        return this.enemigo;
    }

    @Override
    public void mover() {
        this.enemigo.mover();
    }

    @Override
    public void mover(int x, int y) {
        this.enemigo.mover(x, y);

    }
    
}