package views;


import javax.swing.JFrame;
import java.awt.Dimension;


public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    private Tablero tablero;
    private int alto,ancho;

    public View(Tablero tablero){
        this.tablero = tablero;
        this.ancho = 740;
        this.alto = 500;

    }

    public void setWindow(){
        this.setSize(ancho,alto);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMaximumSize(new Dimension(ancho,alto));
        this.setMinimumSize(new Dimension(ancho,alto));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void start(){
        //this.setContentPane(this.tablero);
        this.setWindow();
        this.getContentPane().add(this.tablero);
    }
    
}
