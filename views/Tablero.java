
package lupin.views;

import javax.swing.JPanel;

import lupin.controllers.LlaveController;
import lupin.controllers.LupinController;
import lupin.controllers.abstracts.EnemigoController;

//import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import lupin.models.abstracts.SujetoObservable;
import lupin.models.ObservadorTablero;
import java.util.ArrayList;


public class Tablero extends JPanel implements SujetoObservable{

    private static final long serialVersionUID = 1L;

    private Jugador jugador;
    private ObservadorTablero observer;
    private int cantidadLlaves;
    private PerroGrafico[] perros;
    private GuardianGrafico guardian;
    private ArrayList<LlaveGrafica> llaves;

    public Tablero(EnemigoController[] perrosControllers,LlaveController[] llavesJuego,EnemigoController guardianController,LupinController lupinController) {

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

        this.guardian = new GuardianGrafico(guardianController);

        llaves = new ArrayList<>();
        llaves.add(new LlaveGrafica(llavesJuego[0]));
        llaves.add(new LlaveGrafica(llavesJuego[1]));
        llaves.add(new LlaveGrafica(llavesJuego[2]));

        observer.setEnemigos(this.perros);
        this.addKeyListener(jugador.getPlayerController().getMovimiento());
        
        this.add(this.jugador);
        this.add(this.perros[0]);
        this.add(this.perros[1]);
        this.add(this.perros[2]);
        this.add(this.llaves.get(0));
        this.add(this.llaves.get(1));
        this.add(this.llaves.get(2));
        this.setFocusable(true);
        
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public void setPerros(PerroGrafico[] perros) {
        this.perros = perros;
    }

    public PerroGrafico[] getPerros() {
        return perros;
    }

    public void setGuardian(GuardianGrafico guardian) {
        this.guardian = guardian;
    }

    public GuardianGrafico getGuardian() {
        return guardian;
    }

    public void drawMap(Graphics2D lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.setStroke(new BasicStroke(10));
        lapiz.drawLine(0, 300, 100, 300);
        lapiz.drawLine(150, 300, 540, 300);
        lapiz.drawLine(540, 0, 540, 500);

    }

    @Override
    public void paint(Graphics lapiz) {
        super.paint(lapiz);
        Graphics2D lapizNuevo = (Graphics2D) lapiz;
        this.drawMap(lapizNuevo);

    }

    public void colisiones() {

        Rectangle2D paredInferior = new Rectangle2D.Double(0,300,100,10);
        Rectangle2D paredInferiorDos = new Rectangle2D.Double(150,300,390,10); 
        Rectangle2D paredDerecha = new Rectangle2D.Double(540,0,10,500);

        //areajugador.intersectsLine(0, 300, 540, 300)
        if(this.jugador.getArea().intersects(paredInferior)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorDos)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredDerecha)){
            this.jugador.chocar();
        }

        if(this.jugador.getPlayerController().getLupin().getPosicion().getX() > this.getBounds().getMaxX()){
            this.jugador.chocar();
            
        }
        if(this.jugador.getPlayerController().getLupin().getPosicion().getX() < this.getBounds().getMinX()){
            this.jugador.chocar();
            
        }
        if(this.jugador.getPlayerController().getLupin().getPosicion().getY() > this.getBounds().getMaxY() - 20){
            this.jugador.chocar();
            
        }
        if(this.jugador.getPlayerController().getLupin().getPosicion().getY() < this.getBounds().getMinY()){
            this.jugador.chocar();
        }

        //Colision llaves
        for(LlaveGrafica l:llaves){
            if(this.jugador.getArea().intersects(l.getArea())){
                notificar();
                cantidadLlaves -= 1;
                this.remove(l);
                try{
                    this.llaves.remove(l);
                    this.generarGuardian();
                    
                }catch(Exception e){}
            }
        }
    }

    public void generarGuardian(){
        if(this.llaves.isEmpty()){
            this.guardian.getGuardianController().getEnemigo().setVelocidad(5);
            this.add(this.guardian);
        }
    }

    @Override
    public void notificar() {
        this.observer.setCantidadLlaves(this.cantidadLlaves);
        this.observer.notificarEnemigos();
        this.perros = observer.getEnemigos();
        
    }


}