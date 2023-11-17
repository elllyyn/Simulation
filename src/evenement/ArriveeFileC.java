package evenement;

import entite.Bus;
import simulateur.Simulateur;

public class ArriveeFileC extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.addBusFileC(getBus());
        getBus().setTempsEntreeFileCont(getTemps());

        if (!simulateur.getStatusControle()) {
            simulateur.addEventEcheancier(new AccesControle(getTemps(), getBus()));
        }
    }

    public ArriveeFileC(double tempsSimu, Bus bus) {
        super(tempsSimu, bus);
    }
}
