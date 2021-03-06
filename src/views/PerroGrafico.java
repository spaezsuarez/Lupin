package views;

import controllers.abstracts.EnemigoController;
import views.abstracts.Personaje;
import java.awt.geom.Rectangle2D;

public class PerroGrafico extends Personaje {

    private static final long serialVersionUID = 1L;
    private EnemigoController enemigo;

    public PerroGrafico(EnemigoController enemigo,Jugador jugador){
        this.setSize(50, 12);
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

    public Rectangle2D getArea(){
        return new Rectangle2D.Double(this.getPerroController().getEnemigo().getPosicion().getX(), this.getPerroController().getEnemigo().getPosicion().getY(), 11, 12);
    }
    
}