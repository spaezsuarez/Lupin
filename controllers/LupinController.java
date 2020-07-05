package lupin.controllers;

import lupin.models.Lupin;
import lupin.views.Jugador;
import lupin.views.Tablero;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class LupinController {
    
    private Lupin lupin;
    private LupinMovement movimiento;
    

    public LupinController(Lupin lupin) {
        this.lupin = lupin;
        this.movimiento = new LupinMovement(this);
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

    public LupinMovement(LupinController controller) {
        this.controller = controller;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


    

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
        this.jugador = tablero.getJugador();
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void keyPressed(KeyEvent key) {
        int velocidad = this.controller.getLupin().getVelocidad();
        double x = this.controller.getLupin().getPosicion().getX();
        double y = this.controller.getLupin().getPosicion().getY();

        switch (key.getKeyCode()) {

            case KeyEvent.VK_UP:
                
                this.controller.getLupin().getPosicion().mover(x, y - velocidad);
                break;
            
            case KeyEvent.VK_DOWN:


                this.controller.getLupin().getPosicion().mover(x, y + velocidad);
                break;
            
            case KeyEvent.VK_LEFT:

                this.controller.getLupin().getPosicion().mover(x - velocidad, y);
                break;

            case KeyEvent.VK_RIGHT:

                this.controller.getLupin().getPosicion().mover(x + velocidad, y);
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