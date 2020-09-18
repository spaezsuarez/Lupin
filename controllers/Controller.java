package controllers;

import controllers.threads.EnemigosThread;
import controllers.threads.LupinThread;
import models.ObjetoEscenario;
import models.Posicion;
import views.Tablero;
import views.View;

public class Controller {

    private View ventana;
    private LupinThread hiloLupin;
    private EnemigosThread hiloEnemigos;

    public Controller() {
        LlaveController[] llavesJuego = new LlaveController[] {
            
            new LlaveController(new Posicion(5,400), "Llave"),
            new LlaveController(new Posicion(190,400), "Llave"),
            new LlaveController(new Posicion(370,400), "Llave")
        };

        hiloLupin = new LupinThread(new ObjetoEscenario(new Posicion (615,300)));
        hiloEnemigos = new EnemigosThread(hiloLupin.getLupinController().getLupin());
        Tablero tablero = new Tablero(hiloEnemigos.getPerrosControllers(), llavesJuego,hiloEnemigos.getGuardianController(),hiloLupin.getTesoroController() , hiloLupin.getLupinController());
        hiloLupin.getLupinController().getMovimiento().setTablero(tablero);
        hiloEnemigos.setTablero(tablero);
        ventana = new View(tablero);
    }

    public void start(){
        ventana.start();
        hiloLupin.start();
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("Error en la matrix");
        }
        hiloEnemigos.start();
    }
    
}