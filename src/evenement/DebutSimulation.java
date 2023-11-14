package evenement;

import echeancier.Echeancier;
import ressource.Variable;
import utils.FonctionsUtiles;

public class DebutSimulation implements Evenement {
    @Override public void lancerEvenement() {
        Variable.initialiser();
        int tempsArrivee = (int) (Echeancier.tpsSimulation + FonctionsUtiles.loiExponentielle(Variable.lambdaArriveeBus));
        Echeancier.insererEcheancier(new ArriveeBus(), tempsArrivee);
        Echeancier.insererEcheancier(new FinSimulation(), Variable.tempsSimulation);
    }

    public DebutSimulation() {
        lancerEvenement();
    }
}
