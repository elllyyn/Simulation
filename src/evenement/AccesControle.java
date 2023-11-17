package evenement;

import entite.Bus;
import simulateur.Simulateur;
import utils.*;

public class AccesControle extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.removeBusFileC(getBus());
        simulateur.setStatusControle(true);
        simulateur.addEventEcheancier(new DepartControle(getTemps()
                + FonctionsUtiles.loiUniforme(Constantes.tempsMinControle, Constantes.tempsMaxControle), getBus()));
    }

    public AccesControle(double tempsSimu, Bus bus) {
        super(tempsSimu, bus);
    }
}
