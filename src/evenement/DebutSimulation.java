package evenement;

import entite.Bus;
import simulateur.Simulateur;
import utils.*;

public class DebutSimulation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        double tempsArrivee = getTemps()
                + FonctionsUtiles.loiExponentielle(Constantes.lambdaArriveeBus);
        simulateur.addEventEcheancier(new ArriveeBus(tempsArrivee, new Bus()));
        simulateur.addEventEcheancier(new FinSimulation(getTemps() + Constantes.dureeSimulation, new Bus()));
    }

    public DebutSimulation(double temps, Bus bus) {
        super(temps, bus);
    }
}
