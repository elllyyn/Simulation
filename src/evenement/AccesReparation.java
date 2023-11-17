package evenement;

import entite.Bus;
import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.Constantes;
import utils.FonctionsUtiles;

public class AccesReparation extends Evenement {
    @Override
    public void lancerEvenement(Simulateur simulateur) {
        simulateur.removeBusFileR(getBus());
        getBus().setTempsSortieFileRep(getTemps());
        IndicateurStatistique.setAireQueueReparation(IndicateurStatistique.getAireQueueReparation()
                + (getTemps() - getBus().getTempsEntreeFileRep()));

        simulateur.setStatusReparation((byte)(simulateur.getStatusReparation() + 1));
        double tempsReparation = (getTemps()
                + FonctionsUtiles.loiUniforme(Constantes.tempsMinReparation, Constantes.tempsMaxReparation));
        simulateur.addEventEcheancier(new DepartReparation(tempsReparation, getBus()));
        IndicateurStatistique.setAirePosteReparation(IndicateurStatistique.getAirePosteReparation()
                + (tempsReparation - getTemps()));
    }

    public AccesReparation(double temps, Bus bus) {
        super(temps, bus);
    }
}
