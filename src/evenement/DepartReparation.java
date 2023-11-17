package evenement;

import entite.Bus;
import simulateur.Simulateur;

public class DepartReparation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.setStatusReparation((byte)(simulateur.getStatusReparation() - 1));

        if (simulateur.getListeBusFileR().size() > 0) {
            simulateur.addEventEcheancier(new AccesReparation(getTemps(), simulateur.getListeBusFileR().get(0)));
        }
    }

    public DepartReparation(double temps, Bus bus) {
        super(temps, bus);
    }
}
