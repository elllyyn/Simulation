package statistique;

import simulateur.Simulateur;
import utils.Constantes;

public class IndicateurStatistique {
    private static double tpsAttenteMoyFileControle = 0;
    private static double tpsAttenteMoyFileReparation = 0;
    private static double tauxUtilisationReparation = 0;
    private static double tempsMaxAttControle = 0;
    private static double tempsMaxAttReparation = 0;
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

    public static double getTempsMaxAttControle() {
        return tempsMaxAttControle;
    }

    public static void setTempsMaxAttControle(double tempsMaxAttControle) {
        IndicateurStatistique.tempsMaxAttControle = tempsMaxAttControle;
    }

    public static double getTempsMaxAttReparation() {
        return tempsMaxAttReparation;
    }

    public static void setTempsMaxAttReparation(double tempsMaxAttReparation) {
        IndicateurStatistique.tempsMaxAttReparation = tempsMaxAttReparation;
    }

    public static void majIndicateurs(Simulateur simulateur)
    {
        setTpsAttenteMoyFileControle(getAireQueueControle() / simulateur.getNbBus());
        setTpsAttenteMoyFileReparation(getAireQueueReparation() / simulateur.getNbReparation());
        setTauxUtilisationReparation(getAirePosteReparation() / (2 * Constantes.dureeSimulation));
    }

    public static void printStats(Simulateur simulateur)
    {
        System.out.println("\n----------STATS GLOBALES----------");
        System.out.println("Temps d'attente moyen dans la file de controle sans les bus toujours en attente: " + (tpsAttenteMoyFileControle - (double)simulateur.getTempsToujoursFileCont()));
        System.out.println("Temps d'attente moyen dans la file de reparation sans les bus toujours en attente: " + (tpsAttenteMoyFileReparation - (double)simulateur.getTempsToujoursFileRep()));
        System.out.println("Temps d'attente moyen dans la file de controle avec les bus toujours en attente: " + tpsAttenteMoyFileControle);
        System.out.println("Temps d'attente moyen dans la file de reparation avec les bus toujours en attente: " + tpsAttenteMoyFileReparation);
        System.out.println("Taux d'utilisation du poste de reparation : " + tauxUtilisationReparation);
        System.out.println("Nombre de bus en attente : " + (simulateur.getListeBusFileC().size() + simulateur.getListeBusFileR().size()));
        System.out.println("Nombre de bus total : " + simulateur.getNbBus());
        System.out.println("Taux de bus reparer : " + ((double)simulateur.getNbReparation() / (double)simulateur.getNbBus()) * 100 + "%");
    }

    public static void printTempsMaxContAndRep(Simulateur simulateur){
        System.out.println("\n----------STATS BUS----------");
        System.out.println("Temps max d'attente dans la file de controle : " + IndicateurStatistique.getTempsMaxAttControle());
        System.out.println("Temps max d'attente dans la file de reparation : " + IndicateurStatistique.getTempsMaxAttReparation());
    }
}