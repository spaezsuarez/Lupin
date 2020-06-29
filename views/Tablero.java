package views;

//Elementos Graficos
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Tablero extends JPanel {

    private static final long serialVersionUID = 1L;
    private Jugador j;
    

    public Tablero() {
        this.setBackground(Color.GRAY);
        this.j = new Jugador();
        addKeyListener(j.getPlayerController().getMovimiento());
        setFocusable(true);
        this.add(j);
    }


    public void drawMap(Graphics2D lapiz){
        lapiz.setColor(Color.BLACK);
        lapiz.drawLine(0, 300, 540, 300);
        lapiz.drawLine(540, 0, 540, 500);
        
    }

    @Override
    public void paint(Graphics lapiz){
        super.paint(lapiz);
        Graphics2D lapizNuevo = (Graphics2D)lapiz;
        this.drawMap(lapizNuevo);
        
        
    }

    public void colisiones(){
        //Rectangle2D usar metodo intersects
    }


    
}