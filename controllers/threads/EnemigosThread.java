package lupin.controllers.threads;

import lupin.controllers.GuardianController;
import lupin.controllers.PerroController;
import lupin.models.Guardian;
import lupin.models.Lupin;
import lupin.models.Perro;

public class EnemigosThread extends Thread {

    private PerroController[] perrosControllers;
    private GuardianController guardianController;

    public EnemigosThread(Lupin lupin) {
        perrosControllers = new PerroController[] {
            new PerroController(new Perro(100,200), lupin),
            new PerroController(new Perro(200,300), lupin),
            new PerroController(new Perro(300,200), lupin)
        };

        guardianController = new GuardianController(new Guardian(400, 300), lupin);
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
                System.out.print("Perro: (" + perroController.getEnemigo().getPosicion().getX() + ", " + perroController.getEnemigo().getPosicion().getY() + ") ");
            }
            guardianController.mover();
            System.out.println("Guardian: (" + guardianController.getEnemigo().getPosicion().getX() + ", " + guardianController.getEnemigo().getPosicion().getY() + ")");
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                System.out.println("Error en la Matrix");
            }
        } while(true);
    }

}