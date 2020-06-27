package controllers;

import models.Lupin;
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

}

class LupinMovement implements KeyListener {

    private LupinController controller;

    public LupinMovement(LupinController controller) {
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent key) {
        int velocidad = this.controller.getLupin().getVelocidad();
        int x = this.controller.getLupin().getPosicion().getX();
        int y = this.controller.getLupin().getPosicion().getY();
        int tecla = key.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                
                this.controller.getLupin().getPosicion().mover(x, y + velocidad);
                System.out.println("up");
                break;
            
            case KeyEvent.VK_DOWN:

                this.controller.getLupin().getPosicion().mover(x, y - velocidad);
                System.out.println("down");
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
    }

    @Override
    public void keyTyped(KeyEvent key) {}

    @Override
    public void keyReleased(KeyEvent key) {}

}