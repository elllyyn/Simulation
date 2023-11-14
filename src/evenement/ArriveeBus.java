package evenement;

import echeancier.Echeancier;
import ressource.Variable;
import utils.FonctionsUtiles;

public class ArriveeBus implements Evenement {
    @Override public void lancerEvenement() {
        int tempsArrivee = (int) (Echeancier.tpsSimulation + FonctionsUtiles.loiExponentielle(Variable.lambdaArriveeBus));
        Echeancier.insererEcheancier(new ArriveeBus(), tempsArrivee);
        Variable.nbBus++;
        Echeancier.insererEcheancier(new ArriveeFileC(), Echeancier.tpsSimulation);
    }

    public ArriveeBus() {
        lancerEvenement();
    }
}
