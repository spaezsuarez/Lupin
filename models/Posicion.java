package models;

public class Posicion{

    private double x,y, xLast, yLast;

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

    public double getXLast() {
        return xLast;
    }

    public double getYLast() {
        return yLast;
    }
    
    public void mover(double x,double y){
        xLast = this.x;
        yLast = this.y;
        this.x = x;
        this.y = y;
    }

}