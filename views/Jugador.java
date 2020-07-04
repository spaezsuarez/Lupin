package views;

import controllers.LupinController;
import views.abstracts.*;


public class Jugador extends Personaje{

    private static final long serialVersionUID = 1L;
    private LupinController controller;


    public Jugador(LupinController lupin){
        this.setSize(40,30);
        this.setText("Lupin");
        this.controller = lupin;
    }

    public LupinController getPlayerController(){
        return this.controller;
    }

    public void mover(){
        this.setLocation(this.controller.getLupin().getPosicion().getX(),this.controller.getLupin().getPosicion().getY());
    }

    public void mover(int x, int y){
        int xi = controller.getLupin().getPosicion().getX();
        int yi = controller.getLupin().getPosicion().getY();
        this.controller.getLupin().getPosicion().mover(xi+x,yi+y);
        this.setLocation(this.controller.getLupin().getPosicion().getX(),this.controller.getLupin().getPosicion().getY());

    }
    
    
}