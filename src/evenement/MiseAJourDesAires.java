package evenement;

import ressource.Variable;
import statistique.IndicateurStatistique;

public class MiseAJourDesAires implements Evenement{
    @Override public void lancerEvenement() {
        // R
    }

    public MiseAJourDesAires(int h1, int h2){
        IndicateurStatistique.aireQueueControle = IndicateurStatistique.aireQueueControle + (h2 - h1) * Variable.queueControle.size();
        IndicateurStatistique.aireQueueReparation = IndicateurStatistique.aireQueueReparation + (h2 - h1) * Variable.queueReparation.size();
        IndicateurStatistique.tauxUtilisationReparation = IndicateurStatistique.tauxUtilisationReparation + (h2 - h1) * Variable.statusReparartion;
    }


}
