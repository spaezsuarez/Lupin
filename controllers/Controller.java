package controllers;

import models.Lupin;
import models.Perro;
import views.Tablero;
import views.View;

public class Controller {

    private View ventana;
    private PerroController[] perrosControllers;
    private LupinController lupinController;

    public Controller() {
        lupinController = new LupinController(new Lupin(1,1));

        perrosControllers = new PerroController[]{
            new PerroController(new Perro(100,200), lupinController.getLupin()),
            new PerroController(new Perro(200,300), lupinController.getLupin()),
            new PerroController(new Perro(300,200), lupinController.getLupin())
        };

        Tablero tablero = new Tablero(perrosControllers,lupinController);
        lupinController.getMovimiento().setTablero(tablero);

        ventana = new View(tablero);
        
    }

    public void start(){
        this.ventana.start();
    }
    
}