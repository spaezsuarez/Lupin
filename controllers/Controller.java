package lupin.controllers;

import lupin.controllers.threads.EnemigosThread;
import lupin.controllers.threads.LupinThread;
import lupin.models.Posicion;
import lupin.views.Tablero;
import lupin.views.View;

public class Controller {

    private View ventana;
    private LupinThread hiloLupin;
    private EnemigosThread hiloEnemigos;

    public Controller() {
        LlaveController[] llavesJuego = new LlaveController[]{
            new LlaveController(new Posicion(5,400), "asdass"),
            new LlaveController(new Posicion(200,400), "hola"),
            new LlaveController(new Posicion(400,400), "hola2")
        };

        hiloLupin = new LupinThread();
        hiloEnemigos = new EnemigosThread(hiloLupin.getLupinController().getLupin());
        Tablero tablero = new Tablero(hiloEnemigos.getPerrosControllers(), llavesJuego, hiloLupin.getLupinController());
        hiloLupin.getLupinController().getMovimiento().setTablero(tablero);

        ventana = new View(tablero);
    }

    public void start(){
        ventana.start();
        hiloLupin.start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Error en la matrix");
        }
        hiloEnemigos.start();
    }
    
}