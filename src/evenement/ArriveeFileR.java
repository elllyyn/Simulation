package evenement;

import entite.Bus;
import simulateur.Simulateur;

public class ArriveeFileR extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.addBusFileR(getBus());

        if (simulateur.getStatusReparation() < 2) {
            simulateur.addEventEcheancier(new AccesReparation(getTemps(), getBus()));
        }
    }

    public ArriveeFileR(double temps, Bus bus) {
        super(temps, bus);
    }
}