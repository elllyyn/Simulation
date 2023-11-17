package evenement;

import entite.Bus;
import simulateur.Simulateur;

public class FinSimulation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.getEcheancier().getEvenements().clear();
    }

    public FinSimulation(double temps, Bus bus) {
        super(temps, bus);
    }
}
