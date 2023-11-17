package evenement;

import entite.Bus;
import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.Constantes;

public class FinSimulation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.getEcheancier().getEvenements().clear();

        IndicateurStatistique.setTpsAttenteMoyFileControle(IndicateurStatistique.getAireQueueControle() / simulateur.getNbBus());
        IndicateurStatistique.setTpsAttenteMoyFileReparation(IndicateurStatistique.getAireQueueReparation() / simulateur.getNbReparation());
        IndicateurStatistique.setTauxUtilisationReparation(IndicateurStatistique.getAirePosteReparation() / (2 * Constantes.dureeSimulation));
    }

    public FinSimulation(double temps, Bus bus) {
        super(temps, bus);
    }
}
