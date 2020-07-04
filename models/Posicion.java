package lupin.models;

public class Posicion{

    private double x,y;

    public Posicion(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void mover(double x,double y){
        this.x = x;
        this.y = y;
    }

}