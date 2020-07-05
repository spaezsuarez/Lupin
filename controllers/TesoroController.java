package lupin.controllers;

import lupin.models.ObjetoEscenario;

public class TesoroController {
    private ObjetoEscenario tesoro;
    public TesoroController(ObjetoEscenario tesoro){
        this.tesoro= tesoro;
    }
    public ObjetoEscenario getTesoro() {
        return tesoro;
    }

    public void setTesoro(ObjetoEscenario tesoro) {
        this.tesoro = tesoro;
    }
}
