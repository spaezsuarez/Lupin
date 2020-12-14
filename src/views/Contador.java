package views;

import javax.swing.JLabel;
import java.awt.Font;

public class Contador extends JLabel {

    private static final long serialVersionUID = 1L;
    private int contador;
    
    public Contador() {
        this.contador = 10;
        this.setSize(100, 20);
        this.setFont(new Font("Arial",Font.BOLD,15));
        this.setText("Vidas: " + this.contador);
        this.setLocation(675, 10);
    }

    public void actualizar() {
        this.contador--;
        this.setText("Vidas: " + this.contador);
    }

    public boolean perdio() {
        return this.contador == 0;
    }
    
}