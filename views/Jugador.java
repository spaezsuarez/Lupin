package views;

import controllers.LupinController;
import models.Lupin;
import javax.swing.JLabel;
//import java.awt.Image;
//import javax.swing.ImageIcon;


public class Jugador extends JLabel{

    private static final long serialVersionUID = 1L;
    private LupinController controller;

    public Jugador(){
        this.controller = new LupinController(new Lupin());
        this.setSize(30,30);
        this.setText("lUPIN");
        //ImageIcon forma = new ImageIcon(getClass().getResource("/views/sources/player.jpg"));
        //ImageIcon imagen = new ImageIcon(forma.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        //this.setIcon(imagen);
    }

    public LupinController getPlayerController(){
        return this.controller;
    }

    


    
    
    
}