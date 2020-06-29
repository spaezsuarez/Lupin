package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class Tablero extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;
    // private Jugador j;
    private JLabel personaje;

    public Tablero() {

        this.setBackground(Color.GRAY);
        // this.j = new Jugador();
        // addKeyListener(j.getPlayerController().getMovimiento());
        addKeyListener(this);
        setFocusable(true);
        this.personaje = new JLabel("LUPIN");
        this.personaje.setSize(30, 30);
        this.add(personaje);
    }

    public void drawMap(Graphics2D lapiz) {
        lapiz.setColor(Color.BLACK);
        lapiz.drawLine(0, 300, 540, 300);
        lapiz.drawLine(540, 0, 540, 500);

    }

    @Override
    public void paint(Graphics lapiz) {
        super.paint(lapiz);
        Graphics2D lapizNuevo = (Graphics2D) lapiz;
        this.drawMap(lapizNuevo);

    }

    public void colisiones() {

        if(this.personaje.getX() > this.getBounds().getMaxX()){
            this.personaje.setLocation(this.getX()-10, this.getY());
            
        }
        if(this.personaje.getX() < this.getBounds().getMinX()){
            this.personaje.setLocation(this.getX()+10, this.getY());
            
        }
        if(this.personaje.getY() > this.getBounds().getMaxY()){
            this.personaje.setLocation(this.getX(), this.getY()-10);
            
        }
        if(this.personaje.getY() < this.getBounds().getMinY()){
            this.personaje.setLocation(this.getX(), this.getY()+10);
            
        }
        for (int x = 0; x <= 540; x++) {
            if (this.personaje.getX() == x && this.personaje.getY() == 300) {
                this.personaje.setLocation(this.personaje.getX(),this.personaje.getY()-10);
                
            }
        }
        for(int y = 0; y <= 500; y++){
            if (this.personaje.getX() == 540 && this.personaje.getY() == y) {
                this.personaje.setLocation(this.personaje.getX()-10,this.personaje.getY());
                
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla = e.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                this.personaje.setLocation(personaje.getX(), personaje.getY() - 10);
                this.colisiones();
                break;
            case KeyEvent.VK_DOWN:
                this.personaje.setLocation(personaje.getX(), personaje.getY() + 10);
                this.colisiones();
                break;
            case KeyEvent.VK_RIGHT:
                this.personaje.setLocation(personaje.getX() + 10, personaje.getY());
                this.colisiones();
                break;
            case KeyEvent.VK_LEFT:
                this.personaje.setLocation(personaje.getX() - 10, personaje.getY());
                this.colisiones();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}

}