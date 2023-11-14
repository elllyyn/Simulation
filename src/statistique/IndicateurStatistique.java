package statistique;

import echeancier.Echeancier;
import ressource.Variable;

public class IndicateurStatistique {
    public static double tpsAttenteMoyFileControle;
    public static double tpsAttenteMoyFileReparation;
    public static double tauxUtilisationReparation;
    public static double aireQueueControle = 0;
    public static double aireQueueReparation = 0;

    public void calculerStatistiques(){
        tpsAttenteMoyFileControle = 1/Variable.nbBus * aireQueueControle;
        tpsAttenteMoyFileReparation = 1/Variable.nbReparation * aireQueueReparation;
        tauxUtilisationReparation = 1/(Echeancier.tpsSimulation * 2) * aireQueueReparation;
    }
}
