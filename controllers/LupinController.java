package controllers;

import models.Lupin;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class LupinController {
    
    private Lupin lupin;
    private LupinMovement movimiento;

    public LupinController(Lupin lupin) {
        this.lupin = lupin;
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

    public void setMovimiento() {
        this.movimiento = new LupinMovement(this);
    }

}

class LupinMovement implements KeyListener {

    private LupinController controller;

    public LupinMovement(LupinController controller) {
        this.controller = controller;
    }

    public void keyPressed(KeyEvent key) {
        int velocidad = this.controller.getLupin().getVelocidad();
        int x = this.controller.getLupin().getPosicion().getX();
        int y = this.controller.getLupin().getPosicion().getY();
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                
                this.controller.getLupin().getPosicion().mover(x, y + velocidad);
                break;
            
            case KeyEvent.VK_DOWN:

                this.controller.getLupin().getPosicion().mover(x, y - velocidad);
                break;
            
            case KeyEvent.VK_LEFT:

                this.controller.getLupin().getPosicion().mover(x - velocidad, y);
                break;

            case KeyEvent.VK_RIGHT:

                this.controller.getLupin().getPosicion().mover(x + velocidad, y);
                break;
            
        }
    }

    public void keyTyped(KeyEvent key) {}

    public void keyReleased(KeyEvent key) {}

}