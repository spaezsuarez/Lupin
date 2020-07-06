package lupin.views;

import javax.swing.JLabel;

public class Contador extends JLabel {

    private static final long serialVersionUID = 1L;
    private int contador;
    
    public Contador() {
        this.contador = 10;
        this.setSize(70, 10);
        this.setText("Vidas: " + this.contador);
        this.setLocation(0, 0);
    }

    public void actualizar() {
        this.contador--;
        this.setText("Vidas: " + this.contador);
    }

    public boolean perdio() {
        return this.contador == 0;
    }
    
}