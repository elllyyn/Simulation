package evenement;

import entite.Bus;
import simulateur.Simulateur;

public class ArriveeFileR extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.addBusFileR(getBus());
        getBus().setTempsEntreeFileRep(getTemps());
        simulateur.setNbReparation(simulateur.getNbReparation() + 1);

        if (simulateur.getStatusReparation() < 2) {
            simulateur.addEventEcheancier(new AccesReparation(getTemps(), getBus()));
        }
        else {
            System.out.println("Bus est en attente de reparation");
        }
    }

    public ArriveeFileR(double temps, Bus bus) {
        super(temps, bus);
    }
}