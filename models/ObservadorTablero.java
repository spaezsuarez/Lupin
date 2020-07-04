package models;

import models.abstracts.Observador;
import views.PerroGrafico;
import models.Estados.*;
import models.abstracts.EstadoEnemigo;


public class ObservadorTablero implements Observador {
    private int cantidadLlaves;
    private PerroGrafico[] enemigos;

    public ObservadorTablero(){
        this.enemigos = new PerroGrafico[3];
        this.cantidadLlaves = 0;
    }

    public void setEnemigos(PerroGrafico[] enemigos){
        this.enemigos = enemigos;
    }

    
    public PerroGrafico[] getEnemigos() {
        return this.enemigos;
    }

    public void setEstadoEnemigos(EstadoEnemigo estado){
        for(PerroGrafico e: this.enemigos){
            System.out.println("El estado del enemigo es: " + estado);
            e.getPerroController().getEnemigo().setEstado(estado);
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
            case 3:
                this.setEstadoEnemigos(new EnemigoFacil());
                break;
            case 2:
                this.setEstadoEnemigos(new EnemigoMedio());
                break;
            case 1:
                this.setEstadoEnemigos(new EnemigoDificil());
                break;
            }
            

    }

    @Override
    public void actualizar(){
        this.notificarEnemigos();
    }
    
}