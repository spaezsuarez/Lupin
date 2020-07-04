package lupin.views;

import javax.swing.JLabel;
import java.awt.geom.*;
import lupin.controllers.LlaveController;

public class LlaveGrafica extends JLabel {

    private static final long serialVersionUID = 1L;
    private LlaveController llave;
    private final int x,y;

    public LlaveGrafica(LlaveController llave){

        this.setText("Llave");
        this.setSize(60,40);
        this.llave = llave;
        this.x = this.llave.getLlave().getPosicion().getX();
        this.y = this.llave.getLlave().getPosicion().getY();

        this.setLocation(x,y);

    }

    public LlaveController getLlaveController(){
        return this.llave;
    }

    public Rectangle2D getArea(){
        return new Rectangle2D.Double(x,y,60,40);
    }
    
    
}