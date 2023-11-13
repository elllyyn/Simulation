package statistique;

public class IndicateurStatistique {
    public static double tpsAttenteMoyFileControle;
    public static double tpsAttenteMoyFileReparation;
    public static double tauxUtilisationReparation;
    private static double aireQueueControle;
    private static double aireQueueReparation;

    public void majAire(int h1, int h2){
        aireQueueControle+=(h2-h1)*aireQueueControle;

    }

    public void calculerStatistiques(){
        
    }
}
