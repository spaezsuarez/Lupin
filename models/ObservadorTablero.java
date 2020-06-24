package models;

import models.abstracts.Observador;
import java.util.ArrayList;
import models.Estados.*;
import models.abstracts.EstadoEnemigo;


public class ObservadorTablero implements Observador {
    private int cantidadLlaves;
    private ArrayList<Perro> enemigos;

    public ObservadorTablero(ArrayList<Perro>enemigosTablero){
        this.enemigos = enemigosTablero;
        this.cantidadLlaves = 0;
    }

    public void setEnemigos(Perro enemigo){
        this.enemigos.add(enemigo);
    }

    public ArrayList<Perro> getEnemigos() {
        return this.enemigos;
    }

    public void setEstadoEnemigos(EstadoEnemigo estado){
        for(Perro e: this.enemigos){
            e.setEstado(estado);
        }
    }

    public void setCantidadLlaves(int cantidad){
        this.cantidadLlaves = cantidad;
    }

    public int getCantidadLlaves(){
        return this.cantidadLlaves;
    }

    public void notificarEnemigos(){

        //Recordar que el tablero va a estar diciendole al observadorLupin cuando una llave se vuelve nula
        //Esto quiere decir que la tomo el jugador y va a anotificar a los enemigos
        switch(this.getCantidadLlaves()){
            case 1:
                this.setEstadoEnemigos(new EnemigoFacil());
                break;
            case 2:
                this.setEstadoEnemigos(new EnemigoMedio());
                break;
            case 3:
                this.setEstadoEnemigos(new EnemigoDificil());
                break;
            }
            

    }

    @Override
    public void update(){
        this.notificarEnemigos();
    }
    
}