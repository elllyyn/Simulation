package evenement;

import entite.Bus;
import simulateur.Simulateur;
import utils.*;

public class ArriveeBus extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.addEventEcheancier(
                new ArriveeBus(getTemps() + FonctionsUtiles.loiExponentielle(Constantes.lambdaArriveeBus), new Bus()));
        simulateur.setNbBus(simulateur.getNbBus() + 1);
        simulateur.addBusSysteme(getBus());
        simulateur.addEventEcheancier(new ArriveeFileC(getTemps(), getBus()));
    }

    public ArriveeBus(double tempsSimulation, Bus bus) {
        super(tempsSimulation, bus);
    }
}