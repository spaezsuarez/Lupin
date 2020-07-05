package lupin.views;

import lupin.controllers.GuardianController;
import java.awt.geom.Rectangle2D;
import lupin.views.abstracts.Personaje;

public class GuardianGrafico extends Personaje {

    private static final long serialVersionUID = 1L;
    private GuardianController guardian;

    public GuardianGrafico(GuardianController guardian){
        this.setSize(70,30);
        this.setText("Guardian");
        this.guardian = guardian;
        this.setLocation((int)this.guardian.getEnemigo().getPosicion().getX(),(int)this.guardian.getEnemigo().getPosicion().getY());
    }

    public GuardianController getGuardianController(){
        return this.guardian;
    }

    @Override
    public void mover() {
        this.setLocation((int)guardian.getEnemigo().getPosicion().getX(),(int)guardian.getEnemigo().getPosicion().getY());

    }

    @Override
    public void mover(int x, int y) {
        this.guardian.mover(x, y);
    }

    public Rectangle2D getArea(){
        return new Rectangle2D.Double(this.getGuardianController().getEnemigo().getPosicion().getX(), this.getGuardianController().getEnemigo().getPosicion().getY(),70,30);
    }
    
}