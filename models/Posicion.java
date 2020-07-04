package models;

public class Posicion{

    private int x,y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void mover(int x,int y){
        this.x = x;
        this.y = y;
    }

}