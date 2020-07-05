package lupin.controllers;

import lupin.controllers.abstracts.EnemigoController;
import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.models.ObjetoEscenario;

public class GuardianController extends EnemigoController{

    private ObjetoEscenario tesoro;

    public GuardianController(Guardian guardian, Lupin lupin) {
        super(guardian, lupin);
    }

    public ObjetoEscenario getTesoro() {
        return tesoro;
    }

    public void setTesoro(ObjetoEscenario tesoro) {
        this.tesoro = tesoro;
    }

    @Override
    public void mover() {
        double i = 0;
        boolean xV = (this.getEnemigo().getPosicion().getX() >= tesoro.getPosicion().getX() - 100) && (this.getEnemigo().getPosicion().getX() < tesoro.getPosicion().getX() + 100);
        boolean yV = (this.getEnemigo().getPosicion().getY() <= tesoro.getPosicion().getY());
        if(xV && yV) {
            i = 1;
        } else {
            i = -1;
        }
        double x = this.getEnemigo().getPosicion().getX() + i * this.getEnemigo().getVelocidad();
        double y = -1 * tesoro.getPosicion().getY() + i * Math.sqrt(10000 - Math.pow(tesoro.getPosicion().getX() - x, 2));
        this.mover(x, Math.abs(y));
    }

    @Override
    public void mover(double x, double y) {
        this.getEnemigo().getPosicion().mover(x, y);
        this.getEnemigoGrafico().mover();
    }
    
}