package models;

public class Lupin {
    
    private Posicion posicion;
    private Llave llave;
    private int velocidad;

    public Lupin(int x, int y){
        this.posicion = new Posicion(x,y);
        this.velocidad = 10;
    }

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

    public Llave getLlave(){
        return this.llave;
    }

    public void setLlave(Llave llave){
        this.llave = llave;    
    }
}