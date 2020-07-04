package views;

import javax.swing.JLabel;
import controllers.PerroController;
import models.Perro;

public class EnemigoGrafico extends JLabel {

    private static final long serialVersionUID = 1L;
    private PerroController perro;

    public EnemigoGrafico(Jugador jugador){
        int x = (int)Math.random()*300;
        int y = (int)Math.random()*200;
        this.setSize(40, 30);
        this.setText("Perro");
        this.perro = new PerroController(new Perro(x, y),jugador.getPlayerController().getLupin());
        this.setLocation(this.perro.getEnemigo().getPosicion().getX(), this.perro.getEnemigo().getPosicion().getY());
    }

    public PerroController getPerroController(){
        return this.perro;
    }
    
}