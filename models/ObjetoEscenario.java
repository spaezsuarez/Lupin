package models;

public class ObjetoEscenario {

    private Posicion posicion;
    private String password;

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    
}