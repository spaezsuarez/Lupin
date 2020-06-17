package models;

public class Lupin {
    
    private Posicion posicion;

    private int velocidad;

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public int getVelocidad(){
        return this.velocidad;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void robarLlave(Llave llave){
        llave = null;
         
    }
}