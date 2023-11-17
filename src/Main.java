import simulateur.Simulateur;
import statistique.IndicateurStatistique;

public class Main {
    public static void main(String[] args) {
        Simulateur simulateur = new Simulateur();

        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);
    }
}