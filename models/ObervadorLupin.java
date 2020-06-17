package models;

import models.abstracts.Observador;

public class ObervadorLupin implements Observador {

    private boolean estado;

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }

    @Override
    public void actualizar(){
        
    }
    
    
}