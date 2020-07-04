package views;


import javax.swing.JPanel;
//import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Tablero extends JPanel{

    private static final long serialVersionUID = 1L;
    private Jugador jugador;

    public Tablero() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        this.jugador = new Jugador(this);
        addKeyListener(jugador.getPlayerController().getMovimiento());
        add(this.jugador);
        setFocusable(true);
        
    }

    public void drawMap(Graphics2D lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.setStroke(new BasicStroke(3));
        lapiz.drawLine(0, 300, 540, 300);
        lapiz.drawLine(540, 0, 540, 500);

    }

    @Override
    public void paint(Graphics lapiz) {
        super.paint(lapiz);
        Graphics2D lapizNuevo = (Graphics2D) lapiz;
        this.drawMap(lapizNuevo);

    }

    public void colisiones() {

        Rectangle2D areajugador = new Rectangle2D.Double(jugador.getX(),jugador.getY(),40,30);

        if(areajugador.intersectsLine(0, 300, 540, 300)){
            this.jugador.mover(0,-10);
        }

        if(areajugador.intersectsLine(540, 0, 540, 500)){
            this.jugador.mover(-10, 0);
        }

        if(this.jugador.getX() > this.getBounds().getMaxX()){
            this.jugador.mover(-30, 0);
            
        }
        if(this.jugador.getX() < this.getBounds().getMinX()){
            this.jugador.mover(30, 0);
            
        }
        if(this.jugador.getY() > this.getBounds().getMaxY()){
            this.jugador.mover(0, -10);
            
        }
        if(this.jugador.getY() < this.getBounds().getMinY()){
            this.jugador.mover(0, 10);
            
        }
    }


}