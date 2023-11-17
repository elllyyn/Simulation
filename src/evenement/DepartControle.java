package evenement;

import utils.FonctionsUtiles;
import entite.Bus;
import simulateur.Simulateur;

public class DepartControle extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.setStatusControle(false);

        if (FonctionsUtiles.loiUniforme(0.0, 1.0) <= 0.3) {
            simulateur.addEventEcheancier(new ArriveeFileR(getTemps(), getBus()));
        }
        if (simulateur.getListeBusFileC().size() > 0) {
            simulateur.addEventEcheancier(new AccesControle(getTemps(), simulateur.getListeBusFileC().get(0)));
        }
    }

    public DepartControle(double tempsSimu, Bus bus) {
        super(tempsSimu, bus);
    }
}
