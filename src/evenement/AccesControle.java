package evenement;

import echeancier.Echeancier;
import ressource.Variable;
import utils.FonctionsUtiles;

public class AccesControle implements Evenement {
    @Override public void lancerEvenement() {
        Variable.queueControle--;
        Variable.statusControle = true;
        int tempsControle = (int) (Echeancier.tpsSimulation + FonctionsUtiles.loiUniforme(Variable.tempsMinControle, Variable.tempsMaxControle));
        Echeancier.insererEcheancier(new DepartControle(), tempsControle);
    }

    public AccesControle() {
        lancerEvenement();
    }
}