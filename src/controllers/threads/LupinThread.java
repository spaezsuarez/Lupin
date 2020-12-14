package controllers.threads;

import controllers.LupinController;
import controllers.TesoroController;
import models.Lupin;
import models.ObjetoEscenario;

public class LupinThread extends Thread {

    private LupinController lupinController;
    private TesoroController tesoroController;

    public LupinThread(ObjetoEscenario tesoro) {
        this.lupinController = new LupinController(new Lupin(1,1));
        this.tesoroController= new TesoroController(tesoro);
    }

    public void setLupinController(LupinController lupinController) {
        this.lupinController = lupinController;
    }

    public LupinController getLupinController() {
        return this.lupinController;
    }

    public TesoroController getTesoroController() {
        return tesoroController;
    }

    public void setTesoroController(TesoroController tesoroController) {
        this.tesoroController = tesoroController;
    }
    

    @Override
    public void run() {}
    
}