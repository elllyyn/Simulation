package evenement;

import echeancier.Echeancier;
import ressource.Variable;
import utils.FonctionsUtiles;

public class AccesReparation implements Evenement {
    @Override public void lancerEvenement() {
        Variable.queueReparation--;
        Variable.statusReparartion++;
        int tempsReparation = (int) (Echeancier.tpsSimulation + FonctionsUtiles.loiUniforme(Variable.tempsMinReparation, Variable.tempsMaxReparation));
        Echeancier.insererEcheancier(new DepartReparation(), tempsReparation);
    }

    public AccesReparation() {
        lancerEvenement();
    }
}