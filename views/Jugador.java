package lupin.views;
//import java.awt.Image;
//import javax.swing.ImageIcon;

import lupin.controllers.LupinController;
import lupin.views.abstracts.*;
import java.awt.geom.*;


public class Jugador extends Personaje{

    private static final long serialVersionUID = 1L;
    private LupinController controller;


    

    public Jugador(LupinController lupin){
        this.setSize(40,30);
        this.setText("Lupin");
        this.controller = lupin;
    }

    public LupinController getPlayerController() {
        return this.controller;
    }

    @Override
    public void mover() {
        this.setLocation((int)this.controller.getLupin().getPosicion().getX(), (int)this.controller.getLupin().getPosicion().getY());
    }

    @Override
    public void mover(int x, int y) {}

    public void chocar() {
        this.controller.getLupin().getPosicion().mover(this.controller.getLupin().getPosicion().getXLast(), this.controller.getLupin().getPosicion().getYLast());
        this.setLocation((int)this.controller.getLupin().getPosicion().getX(), (int)this.controller.getLupin().getPosicion().getY());
    }


    public Rectangle2D getArea(){
        return new Rectangle2D.Double(this.getX(),this.getY(),40,30);
    }

    
    
}