package controllers;

import models.Lupin;
import views.Jugador;
import views.Tablero;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class LupinController {
    
    private Lupin lupin;
    private LupinMovement movimiento;
    

    public LupinController(Lupin lupin,Jugador jugador, Tablero tablero) {
        this.lupin = lupin;
        this.movimiento = new LupinMovement(this,jugador,tablero);
    }

    public Lupin getLupin() {
        return this.lupin;
    }

    public void setLupin(Lupin lupin) {
        this.lupin = lupin;
    }

    public LupinMovement getMovimiento() {
        return this.movimiento;
    }

    public void setMovimiento(LupinMovement movimiento) {
        this.movimiento = movimiento;
    }

}

class LupinMovement implements KeyListener {

    private LupinController controller;
    private Tablero tablero;
    private Jugador jugador;

    public LupinMovement(LupinController controller,Jugador jugador,Tablero tablero) {
        this.controller = controller;
        this.tablero = tablero;
        this.jugador = jugador;
    }

    @Override
    public void keyPressed(KeyEvent key) {
        int velocidad = this.controller.getLupin().getVelocidad();
        int x = this.controller.getLupin().getPosicion().getX();
        int y = this.controller.getLupin().getPosicion().getY();
        int tecla = key.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                
<<<<<<< HEAD
                this.controller.getLupin().getPosicion().mover(x, y + velocidad);
                System.out.println("up");
=======
                this.controller.getLupin().getPosicion().mover(x, y - velocidad);
>>>>>>> origin/Controllers
                break;
            
            case KeyEvent.VK_DOWN:

<<<<<<< HEAD
                this.controller.getLupin().getPosicion().mover(x, y - velocidad);
                System.out.println("down");
=======
                this.controller.getLupin().getPosicion().mover(x, y + velocidad);
>>>>>>> origin/Controllers
                break;
            
            case KeyEvent.VK_LEFT:

                this.controller.getLupin().getPosicion().mover(x - velocidad, y);
                System.out.println("left");
                break;

            case KeyEvent.VK_RIGHT:

                this.controller.getLupin().getPosicion().mover(x + velocidad, y);
                System.out.println("right");
                break;
            
        }
        this.jugador.mover();
        this.tablero.colisiones();
    }

    @Override
    public void keyTyped(KeyEvent key) {}

    @Override
    public void keyReleased(KeyEvent key) {}

}