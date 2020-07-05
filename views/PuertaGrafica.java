package lupin.views;

import java.awt.geom.*;

public class PuertaGrafica {
    private Rectangle2D forma;

    public PuertaGrafica(int x, int y,int ancho,int alto){
        this.forma = new Rectangle2D.Double(x,y,ancho,alto);
    }

    public Rectangle2D getForma(){
        return this.forma;
    }
    
}