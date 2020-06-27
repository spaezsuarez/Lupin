package views;

//Elementos Graficos
//import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/*import java.awt.Image;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;*/

//Modelos

//Controladores

public class Tablero extends JPanel {

    private static final long serialVersionUID = 1L;
    private Jugador j;
    //private ImageIcon mapa;

    public Tablero() {
        this.setBackground(Color.GRAY);
        this.j = new Jugador();
        addKeyListener(j.getPlayerController().getMovimiento());
        setFocusable(true);
        this.add(j);
    }


    public void drawMap(){
        /*File imagen = new File("https://i.pinimg.com/originals/80/84/83/8084835653bb683b79b717f763ce91dd.jpg");

        try{
            this.mapa = ImageIO.read(imagen);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }*/

       /* try{
            this.mapa = new ImageIcon(getClass().getResource("viwes/sources/mapa.png"));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }*/    
    }

    public void drawMap(Graphics2D lapiz){
        lapiz.setColor(Color.BLACK);
        lapiz.drawLine(0, 300, 540, 300);
        lapiz.drawLine(540, 0, 540, 500);
        
    }

    @Override
    public void paint(Graphics lapiz){
        Graphics2D lapizNuevo = (Graphics2D)lapiz;
        super.paint(lapiz);

        //lapizNuevo.drawImage(this.mapa.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
        //this.setOpaque(true);
        this.drawMap(lapizNuevo);
        
        
    }

    public void colisiones(){
        //Rectangle2D usar metodo intersects
    }


    
}