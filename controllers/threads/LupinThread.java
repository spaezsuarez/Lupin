package lupin.controllers.threads;

import lupin.controllers.LupinController;
import lupin.models.Lupin;

public class LupinThread extends Thread {

    private LupinController lupinController;

    public LupinThread() {
        this.lupinController = new LupinController(new Lupin(1,1));
    }

    public void setLupinController(LupinController lupinController) {
        this.lupinController = lupinController;
    }

    public LupinController getLupinController() {
        return this.lupinController;
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