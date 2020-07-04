package lupin.controllers.threads;

import lupin.controllers.GuardianController;
import lupin.controllers.PerroController;
import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.models.Perro;
import lupin.views.Tablero;

public class EnemigosThread extends Thread {

    private PerroController[] perrosControllers;
    private GuardianController guardianController;

    public EnemigosThread(Lupin lupin) {
        perrosControllers = new PerroController[] {
            new PerroController(new Perro(100,200, 1), lupin),
            new PerroController(new Perro(200,300, 2), lupin),
            new PerroController(new Perro(300,200, 3), lupin)
        };

        guardianController = new GuardianController(new Guardian(400, 300, 1), lupin);
    }

    public void setTablero(Tablero tablero) {
        perrosControllers[0].setPerroGrafico(tablero.getPerros()[0]);
        perrosControllers[1].setPerroGrafico(tablero.getPerros()[1]);
        perrosControllers[2].setPerroGrafico(tablero.getPerros()[2]);
    }

    public void setPerrosControllers(PerroController[] perrosControllers) {
        this.perrosControllers = perrosControllers;
    }

    public PerroController[] getPerrosControllers() {
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
            for(PerroController perroController : perrosControllers) {
                perroController.mover();
                System.out.println("Velocidad: " + perroController.getEnemigo().getVelocidad());
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