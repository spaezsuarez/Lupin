package views.abstracts;

import javax.swing.JLabel;

public abstract class Personaje extends JLabel {

    private static final long serialVersionUID = 1L;

    public abstract void mover();

    public abstract void mover(int x , int y);


    
}