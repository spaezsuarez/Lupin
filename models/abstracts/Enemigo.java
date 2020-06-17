package models.abstracts;

public abstract class Enemigo {

    protected int velocidad;

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public int getVelocidad(){
        return this.velocidad;
    }

    public abstract void moverse();
    
}