package evenement;

import echeancier.Echeancier;
import ressource.Variable;

public class ArriveeFileC implements Evenement {
    @Override public void lancerEvenement() {
        Variable.queueControle++;

        if (Variable.statusControle){
            Echeancier.insererEcheancier(new AccesControle(), Echeancier.tpsSimulation);
        }
    }

    public ArriveeFileC() {
        lancerEvenement();
    }
}
