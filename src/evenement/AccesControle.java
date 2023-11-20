package evenement;

import entite.Bus;
import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.*;

public class AccesControle extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.removeBusFileC(getBus());
        getBus().setTempsSortieFileCont(getTemps());
        simulateur.setNbBusAccesControle(simulateur.getNbBusAccesControle() + 1);

        if (getBus().getTempsSortieFileCont() - getBus().getTempsEntreeFileCont() > IndicateurStatistique.getTempsMaxAttControle()) {
            IndicateurStatistique.setTempsMaxAttControle(getBus().getTempsSortieFileCont() - getBus().getTempsEntreeFileCont());
        }

        simulateur.setStatusControle(true);
        simulateur.addEventEcheancier(new DepartControle(getTemps()
                + FonctionsUtiles.loiUniforme(Constantes.tempsMinControle, Constantes.tempsMaxControle), getBus()));
    }

    public AccesControle(double tempsSimu, Bus bus) {
        super(tempsSimu, bus);
    }
}
