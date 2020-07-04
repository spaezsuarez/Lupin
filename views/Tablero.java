package views;

import javax.swing.JPanel;
//import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import models.abstracts.SujetoObservable;
import models.ObservadorTablero;
import models.Perro;

import java.util.ArrayList;

public class Tablero extends JPanel implements SujetoObservable{

    private static final long serialVersionUID = 1L;

    private Jugador jugador;
    private EnemigoGrafico perroUno,perroDos,perroTres;
    private ObservadorTablero observer;
    private int cantidadLlaves = 3;
    private ArrayList<Perro> perros;

    public Tablero() {

        this.setLayout(null);
        this.setBackground(Color.GRAY);

        jugador = new Jugador(this);
        perroUno = new EnemigoGrafico(jugador);
        perroDos = new EnemigoGrafico(jugador);
        perroTres = new EnemigoGrafico(jugador);
        
        observer = new ObservadorTablero();
        perros = new ArrayList<Perro>();

        perros.add(perroUno.getPerroController().getPerro());
        perros.add(perroDos.getPerroController().getPerro());
        perros.add(perroTres.getPerroController().getPerro());

        observer.setEnemigos(perros);
        this.addKeyListener(jugador.getPlayerController().getMovimiento());

        this.add(this.jugador);
        this.add(this.perroUno);
        this.add(this.perroDos);
        this.add(this.perroTres);
        this.setFocusable(true);
        
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
        }

        if(areajugador.intersectsLine(540, 0, 540, 500)){
            this.jugador.mover(-10, 0);
            if(cantidadLlaves > 0){
                this.cantidadLlaves -= 1;
                this.notificar();
            }
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
        this.perros =  observer.getEnemigos();
    }


}