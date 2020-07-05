package lupin.models;

public class ObjetoEscenario {

    private Posicion posicion;
    private String password;

    public ObjetoEscenario(Posicion posicion, String password) {
        this.posicion = posicion;
        this.password = password;
    }

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

    public ObjetoEscenario(Posicion posicion) {
        this.posicion = posicion;
    }
    
    
}