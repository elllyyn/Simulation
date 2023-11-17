package evenement;

import utils.FonctionsUtiles;
import entite.Bus;
import simulateur.Simulateur;

public class DepartControle extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.setStatusControle(false);

        if (simulateur.getListeBusFileC().size() > 0) {
            simulateur.addEventEcheancier(new AccesControle(getTemps(), simulateur.getListeBusFileC().get(0)));
        } else {
            if (FonctionsUtiles.loiUniforme(0, 1) <= 0.3) {
                simulateur.addEventEcheancier(new ArriveeFileR(getTemps(), getBus()));
            }

        }
    }

    public DepartControle(double tempsSimu, Bus bus) {
        super(tempsSimu, bus);
    }
}
