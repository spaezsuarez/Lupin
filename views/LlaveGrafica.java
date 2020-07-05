package lupin.views;

import java.awt.Image;
import javax.swing.JLabel;
import java.awt.geom.*;
import javax.swing.ImageIcon;
import lupin.controllers.LlaveController;

public class LlaveGrafica extends JLabel {

    private static final long serialVersionUID = 1L;
    private LlaveController llave;
    private final double x,y;


    public LlaveGrafica(LlaveController llave){
        this.setSize(60,40);
        /*String rutaImg = new String();
        rutaImg= "img/1.jpg";
        ImageIcon imagenExterna = new ImageIcon(rutaImg);
        Image Img= imagenExterna.getImage();
        Image nuevaimagen = Img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen= new ImageIcon(nuevaimagen);
        this.setIcon(imagen);
        this.setVisible(true);
*/
        //this.setIcon(new ImageIcon("/img/1.jpg"));
       // this.setVisible(true);
        this.llave = llave;
        this.x = this.llave.getLlave().getPosicion().getX();
        this.y = this.llave.getLlave().getPosicion().getY();
        this.setLocation((int)x, (int)y);

    }

    public LlaveController getLlaveController(){
        return this.llave;
    }

    public Rectangle2D getArea(){
        return new Rectangle2D.Double(x,y,60,40);
    }

    
    
}