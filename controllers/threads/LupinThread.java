package lupin.controllers.threads;

import lupin.controllers.LupinController;
import lupin.controllers.TesoroController;
import lupin.models.Lupin;
import lupin.models.ObjetoEscenario;

public class LupinThread extends Thread {

    private LupinController lupinController;
    private TesoroController tesoroController;

    public LupinThread(ObjetoEscenario tesoro) {
        this.lupinController = new LupinController(new Lupin(1,1));
        this.tesoroController= new TesoroController (tesoro);
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
    public void run() {
        do {
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                System.out.println("Error en la Matrix");
            }
        } while(true);
    }
    
}