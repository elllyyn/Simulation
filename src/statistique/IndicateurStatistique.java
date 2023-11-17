package statistique;

import simulateur.Simulateur;

public class IndicateurStatistique {
    private static double tpsAttenteMoyFileControle = 0;
    private static double tpsAttenteMoyFileReparation = 0;
    private static double tauxUtilisationReparation = 0;
    private static double aireQueueControle = 0;
    private static double aireQueueReparation = 0;
    private static double airePosteReparation = 0;

    public static double getTpsAttenteMoyFileControle() {
        return tpsAttenteMoyFileControle;
    }

    public static void setTpsAttenteMoyFileControle(double tpsAttenteMoyFileControle) {
        IndicateurStatistique.tpsAttenteMoyFileControle = tpsAttenteMoyFileControle;
    }

    public static double getTpsAttenteMoyFileReparation() {
        return tpsAttenteMoyFileReparation;
    }

    public static void setTpsAttenteMoyFileReparation(double tpsAttenteMoyFileReparation) {
        IndicateurStatistique.tpsAttenteMoyFileReparation = tpsAttenteMoyFileReparation;
    }

    public static double getTauxUtilisationReparation() {
        return tauxUtilisationReparation;
    }

    public static void setTauxUtilisationReparation(double tauxUtilisationReparation) {
        IndicateurStatistique.tauxUtilisationReparation = tauxUtilisationReparation;
    }

    public static double getAireQueueControle() {
        return aireQueueControle;
    }

    public static void setAireQueueControle(double aireQueueControle) {
        IndicateurStatistique.aireQueueControle = aireQueueControle;
    }

    public static double getAireQueueReparation() {
        return aireQueueReparation;
    }

    public static void setAireQueueReparation(double aireQueueReparation) {
        IndicateurStatistique.aireQueueReparation = aireQueueReparation;
    }

    public static double getAirePosteReparation() {
        return airePosteReparation;
    }

    public static void setAirePosteReparation(double airePosteReparation) {
        IndicateurStatistique.airePosteReparation = airePosteReparation;
    }

    public static void printStats()
    {
        System.out.println("\n----------STATS GLOBALES----------");
        System.out.println("Temps d'attente moyen dans la file de controle : " + tpsAttenteMoyFileControle);
        System.out.println("Temps d'attente moyen dans la file de reparation : " + tpsAttenteMoyFileReparation);
        System.out.println("Taux d'utilisation du poste de reparation : " + tauxUtilisationReparation);
    }

    public static void printTempsMaxContAndRep(Simulateur simulateur){
        System.out.println("\n----------STATS BUS----------");
        System.out.println("Temps max d'attente dans la file de controle : " + simulateur.getTempsMaxAttControle());
        System.out.println("Temps max d'attente dans la file de reparation : " + simulateur.getTempsMaxAttRep());
    }
}