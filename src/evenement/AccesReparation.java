package evenement;

import entite.Bus;
import simulateur.Simulateur;
import utils.Constantes;
import utils.FonctionsUtiles;

public class AccesReparation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.removeBusFileR(getBus());
        simulateur.setStatusReparation((byte)(simulateur.getStatusReparation() + 1));
        double tempsReparation = (getTemps()
                + FonctionsUtiles.loiUniforme(Constantes.tempsMinReparation, Constantes.tempsMaxReparation));
        simulateur.addEventEcheancier(new DepartReparation(tempsReparation, getBus()));
    }

    public AccesReparation(double temps, Bus bus) {
        super(temps, bus);
    }
}
