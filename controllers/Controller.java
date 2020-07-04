package lupin.controllers;

import lupin.models.Lupin;
import lupin.models.Perro;
import lupin.models.Posicion;
import lupin.views.Tablero;
import lupin.views.View;

public class Controller {

    private View ventana;
    private PerroController[] perrosControllers;
    private LupinController lupinController;
    private LlaveController[] llavesJuego;

    public Controller() {
        lupinController = new LupinController(new Lupin(1,1));

        perrosControllers = new PerroController[]{
            new PerroController(new Perro(100,200), lupinController.getLupin()),
            new PerroController(new Perro(200,300), lupinController.getLupin()),
            new PerroController(new Perro(300,200), lupinController.getLupin())
        };

        llavesJuego = new LlaveController[]{
            new LlaveController(new Posicion(5,400), "asdass"),
            new LlaveController(new Posicion(200,400), "hola"),
            new LlaveController(new Posicion(400,400), "hola2")
        };



        Tablero tablero = new Tablero(perrosControllers,llavesJuego,lupinController);
        lupinController.getMovimiento().setTablero(tablero);

        ventana = new View(tablero);
        
    }

    public void start(){
        this.ventana.start();
    }
    
}