package models;

import models.abstracts.Observador;
import java.util.ArrayList;
import models.Estados.*;
import models.abstracts.Enemigo;
import models.abstracts.EstadoEnemigo;


public class ObervadorTablero implements Observador {
    private int cantidadLlaves;
    private ArrayList<Enemigo> enemigos;

    public ObervadorTablero(){
        this.enemigos = new ArrayList<>();
        this.cantidadLlaves = 0;
    }

    public void setEnemigos(Enemigo enemigo){
        this.enemigos.add(enemigo);
    }

    public ArrayList<Enemigo> getEnemigos() {
        return this.enemigos;
    }

    public void setEstadoEnemigos(EstadoEnemigo estado){
        for(Enemigo e: this.enemigos){
            e.setEstado(estado);
        }
    }

    public void setNumeroLlaves(int cantidad){
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
    public void actualizar(){
        this.notificarEnemigos();
    }
    
}