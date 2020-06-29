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
    }

    public LupinController getPlayerController(){
        return this.controller;
    }
    
    
}