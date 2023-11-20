import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.FonctionsUtiles;
import utils.Constantes;

public class Main {
    public static void main(String[] args) {
        Simulateur simulateur = new Simulateur();

        Constantes.dureeSimulation = 40;
        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);

        Constantes.dureeSimulation = 80;
        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);

        Constantes.dureeSimulation = 160;
        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);

        Constantes.dureeSimulation = 240;
        simulateur.lancerSimulation();
        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);
        FonctionsUtiles.exportSimuToCSV(simulateur);
    }
}