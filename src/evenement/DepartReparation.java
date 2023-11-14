package evenement;

import echeancier.Echeancier;
import ressource.Variable;

public class DepartReparation implements Evenement {
    @Override public void lancerEvenement() {
        Variable.statusReparartion--;
        if (Variable.queueReparation > 0){
            Echeancier.insererEcheancier(new AccesReparation(), Echeancier.tpsSimulation);
        }
    }

    public DepartReparation() {
        lancerEvenement();
    }
}