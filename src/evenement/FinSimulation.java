package evenement;

import echeancier.Echeancier;

public class FinSimulation implements Evenement{
    @Override public void lancerEvenement() {
        while (Echeancier.evenements.size() > 0) {
            Echeancier.evenements.remove(0);
        }
    }

    public FinSimulation() {
        lancerEvenement();
    }
}
