import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.FonctionsUtiles;

public class Main {
    public static void main(String[] args) {
        Simulateur simulateur = new Simulateur();

        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);
        FonctionsUtiles.exportSimuToCSV(simulateur);
    }
}