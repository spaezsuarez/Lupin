package views;

import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import controllers.TesoroController;

public class TesoroGrafico extends JLabel{
    private static final long serialVersionUID = 1L;
    private TesoroController tesoro;
    private final double x,y;


    public TesoroGrafico(TesoroController tesoro){
        this.setSize(11,11);
        this.setText("▀");
        this.tesoro = tesoro;
        this.x = this.tesoro.getTesoro().getPosicion().getX();
        this.y = this.tesoro.getTesoro().getPosicion().getY();
        this.setLocation((int)x, (int)y);

    }

    public TesoroController getTesoroController(){
        return this.tesoro;
    }

    public Rectangle2D getArea(){
        return new Rectangle2D.Double(x, y, 11, 11);
    }
    
}
