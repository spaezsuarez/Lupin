package views;

import javax.swing.JPanel;

import controllers.LupinController;
import controllers.PerroController;

//import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import models.abstracts.SujetoObservable;
import models.ObservadorTablero;


public class Tablero extends JPanel implements SujetoObservable{

    private static final long serialVersionUID = 1L;

    private Jugador jugador;
    private ObservadorTablero observer;
    private int cantidadLlaves;
    private PerroGrafico[] perros;

    public Tablero(PerroController[] perrosControllers,LupinController lupinController) {

        this.setLayout(null);
        this.setBackground(Color.GRAY);
        
        cantidadLlaves = 3;
        observer = new ObservadorTablero();
        jugador = new Jugador(lupinController);
        
        this.perros = new PerroGrafico[]{
            new PerroGrafico(perrosControllers[0], jugador),
            new PerroGrafico(perrosControllers[1], jugador),
            new PerroGrafico(perrosControllers[2], jugador)
        };

        observer.setEnemigos(this.perros);
        this.addKeyListener(jugador.getPlayerController().getMovimiento());
        
        this.add(this.jugador);
        this.setFocusable(true);
        
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public void drawMap(Graphics2D lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.setStroke(new BasicStroke(5));
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
            //Logica de colision con una llave
            /*notificar();
            cantidadLlaves--;*/ 
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

    @Override
    public void notificar() {
        this.observer.setNumeroLlaves(this.cantidadLlaves);
        this.observer.notificarEnemigos();
        this.perros = observer.getEnemigos();
        
    }


}