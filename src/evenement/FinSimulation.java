package evenement;

import entite.Bus;
import simulateur.Simulateur;
import statistique.IndicateurStatistique;

public class FinSimulation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.getEcheancier().getEvenements().clear();
        IndicateurStatistique.majIndicateurs(simulateur);
    }

    public FinSimulation(double temps, Bus bus) {
        super(temps, bus);
    }
}
