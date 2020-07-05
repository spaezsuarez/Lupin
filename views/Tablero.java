
package lupin.views;

import javax.swing.JPanel;

import lupin.controllers.GuardianController;
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
import java.util.ConcurrentModificationException;
import lupin.controllers.TesoroController;


public class Tablero extends JPanel implements SujetoObservable{

    private static final long serialVersionUID = 1L;
    private Jugador jugador;
    private ObservadorTablero observer;
    private int cantidadLlaves;
    private PerroGrafico[] perros;
    private GuardianGrafico guardian;
    private ArrayList<LlaveGrafica> llaves;
    private boolean estadoPuerta1 = false,estadoPuerta2 = false,estadoPuerta3 = false;
    private PuertaGrafica puertaUno,puertaDos,puertaTres;
    private TesoroGrafico tesoro;
    


    public Tablero(EnemigoController[] perrosControllers, LlaveController[] llavesJuego, GuardianController guardianController, TesoroController tesoro, LupinController lupinController) {

        this.setLayout(null);
        Color color = new Color(153,134,244);
        this.setBackground(color);
        this.tesoro= new TesoroGrafico(tesoro);
        
        puertaUno = new PuertaGrafica(235, 297, 60, 1);
        puertaDos = new PuertaGrafica(405, 297, 60, 1);
        puertaTres = new PuertaGrafica(540, 55, 1, 40);
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
        this.add(this.tesoro);
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

    public void setTesoro(TesoroGrafico tesoro) {
        this.tesoro = tesoro;
    }

    public TesoroGrafico getTesoro() {
        return tesoro;
    }

    public void drawMap(Graphics2D lapiz) {
        lapiz.setStroke(new BasicStroke(10));


        //Paredes horizontales
        lapiz.drawLine(0, 300, 30, 300); //paredi1
        lapiz.drawLine(100, 300, 180, 300); //paredi2
        //---------------------------------
        lapiz.drawLine(180, 300, 230, 300); //paredi3
        lapiz.drawLine(300, 300, 360, 300); //paredi4
        //---------------------------------
        lapiz.drawLine(360, 300, 400, 300); //paredi5
        lapiz.drawLine(470, 300, 540, 300); //paredi6
        //pared laterales intermedias
        lapiz.drawLine(180, 300, 180, 500);
        lapiz.drawLine(360, 300, 360, 500);
       
        //Pared lateral grande
        lapiz.drawLine(540, 0, 540, 50);
        lapiz.drawLine(540, 100, 540, 500);

        //Dibujo puertas
        lapiz.setStroke(new BasicStroke(4));
        lapiz.setColor(Color.WHITE);
        

        if(estadoPuerta1 == false){
            lapiz.draw(puertaUno.getForma());
        }
        if(estadoPuerta2 == false){
            lapiz.draw(puertaDos.getForma());
        }
        if(estadoPuerta3 == false){
            lapiz.draw(puertaTres.getForma());
        }
        
    }

    @Override
    public void paint(Graphics lapiz) {
        super.paint(lapiz);
        Graphics2D lapizNuevo = (Graphics2D) lapiz;
        this.drawMap(lapizNuevo);

    }

    public void colisiones() {

        Rectangle2D paredInferiorUno = new Rectangle2D.Double(0,300,30,10);
        Rectangle2D paredInferiorDos = new Rectangle2D.Double(100,300,80,10);
        Rectangle2D paredInferiorTres = new Rectangle2D.Double(180,300,50,10);
        Rectangle2D paredInferiorCuatro = new Rectangle2D.Double(300,300,60,10);
        Rectangle2D paredInferiorCinco = new Rectangle2D.Double(360,300,40,10);
        Rectangle2D paredInferiorSeis = new Rectangle2D.Double(470,300,60,10);
        Rectangle2D paredDerechaUno = new Rectangle2D.Double(540,0,10,50);
        Rectangle2D paredDerechaDos = new Rectangle2D.Double(540,100,10,400);
        Rectangle2D paredDerechatres = new Rectangle2D.Double(180,300,10,200);
        Rectangle2D paredDerechault = new Rectangle2D.Double(360,300,10,200);

        

        //areajugador.intersectsLine(0, 300, 540, 300)
        if(this.jugador.getArea().intersects(paredInferiorUno)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorDos)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredDerechaUno)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorTres)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorCuatro)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorCinco)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredInferiorSeis)){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(paredDerechaDos)){
            this.jugador.chocar();
        }
        if (this.jugador.getArea().intersects(paredDerechatres)){
            this.jugador.chocar();
        }
        if (this.jugador.getArea().intersects(paredDerechault)){
            this.jugador.chocar();
        }

        if(this.jugador.getArea().intersects(puertaUno.getForma()) && estadoPuerta1 == false){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(puertaDos.getForma()) && estadoPuerta2 == false){
            this.jugador.chocar();
        }
        if(this.jugador.getArea().intersects(puertaTres.getForma()) && estadoPuerta3 == false){
            this.jugador.chocar();
        }

        if(this.jugador.getArea().intersectsLine(735,0,735,500)){
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
                    generarGuardian();
                    cambiarPuerta();
                    
                }catch(ConcurrentModificationException e){
                    System.out.println(" ");
                }
            }
        }
    }

    public void cambiarPuerta(){
        switch(this.llaves.size()){
            case 0:
                estadoPuerta3 = true;
                repaint();
                break;
            case 1:
                estadoPuerta2 = true;
                repaint();
                break;
            case 2:
                estadoPuerta1 = true;
                repaint();
                break;
        }
    }

    public void generarGuardian(){
        if(this.llaves.isEmpty()){
            this.guardian.getGuardianController().getEnemigo().setVelocidad(10);
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