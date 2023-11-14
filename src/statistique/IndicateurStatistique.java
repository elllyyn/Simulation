package statistique;

import echeancier.Echeancier;
import ressource.Variable;

public class IndicateurStatistique {
    public static double tpsAttenteMoyFileControle;
    public static double tpsAttenteMoyFileReparation;
    public static double tauxUtilisationReparation;
    private static double aireQueueControle = 0;
    private static double aireQueueReparation = 0;

    public void majAire(int h1, int h2){
        aireQueueControle+=(h2-h1)*aireQueueControle;
    }

    public void calculerStatistiques(){
        tpsAttenteMoyFileControle = 1 / Variable.nbBus * aireQueueControle;
        tpsAttenteMoyFileReparation = 1 / Variable.nbReparation * aireQueueReparation;
        tauxUtilisationReparation = 1 / (Echeancier.tpsSimulation * 2) * aireQueueReparation;
    }
}
