package lupin.controllers.threads;

import lupin.controllers.GuardianController;
import lupin.controllers.abstracts.EnemigoController;
import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.models.Perro;
import lupin.views.Tablero;

public class EnemigosThread extends Thread {

    private EnemigoController[] perrosControllers;
    private GuardianController guardianController;

    public EnemigosThread(Lupin lupin) {
        perrosControllers = new EnemigoController[] {
            new EnemigoController(new Perro(100,420, 10), lupin),
            new EnemigoController(new Perro(300,420, 11), lupin),
            new EnemigoController(new Perro(480,420, 12), lupin)
        };

        guardianController = new GuardianController(new Guardian(566, 309.94, 0), lupin);
    }

    public void setTablero(Tablero tablero) {
        perrosControllers[0].setEnemigoGrafico(tablero.getPerros()[0]);
        perrosControllers[1].setEnemigoGrafico(tablero.getPerros()[1]);
        perrosControllers[2].setEnemigoGrafico(tablero.getPerros()[2]);
        guardianController.setEnemigoGrafico(tablero.getGuardian());
        guardianController.setTesoro(tablero.getTesoro().getTesoroController().getTesoro());
    }

    public void setPerrosControllers(EnemigoController[] perrosControllers) {
        this.perrosControllers = perrosControllers;
    }

    public EnemigoController[] getPerrosControllers() {
        return this.perrosControllers;
    }

    public void setGuardianController(GuardianController guardianController) {
        this.guardianController = guardianController;
    }

    public GuardianController getGuardianController() {
        return this.guardianController;
    }

    @Override
    public void run() {
        do {
            for(EnemigoController perroController : perrosControllers) {
                perroController.mover();
            }
            guardianController.mover();
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("Error en la Matrix");
            }
        } while(true);
    }

}