import simulateur.Simulateur;
import statistique.IndicateurStatistique;
import utils.FonctionsUtiles;
import utils.Constantes;

public class Main {
    public static void main(String[] args) {
        testHardStats();
        // testSurUnSimulateur();
        // testMaxTemps();
    }

    public static void testSurUnSimulateur() {
        Simulateur simulateur = new Simulateur();
        simulateur.lancerSimulation();
        Constantes.dureeSimulation = 160;

        IndicateurStatistique.printStats(simulateur);
        IndicateurStatistique.printTempsMaxContAndRep(simulateur);
    }

    public static void testHardStats() {
        // Tableau de 1000 simulateurs
        Simulateur[] simulateurs = new Simulateur[20000];
        FonctionsUtiles.createFoldersAndFiles();

        for (int i = 0; i < 5000; i++) {
            Constantes.dureeSimulation = 40;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results40.csv");
        }

        for (int i = 5000; i < 10000; i++) {
            Constantes.dureeSimulation = 80;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results80.csv");
        }

        for (int i = 10000; i < 15000; i++) {
            Constantes.dureeSimulation = 160;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results160.csv");
        }

        for (int i = 15000; i < 20000; i++) {
            Constantes.dureeSimulation = 240;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results240.csv");
        }
    }

    public static void testMaxTemps() {
        Simulateur[] simulateurs = new Simulateur[4000];
        FonctionsUtiles.createFoldersAndFiles();

        for (int i = 0; i < 1000; i++) {
            Constantes.dureeSimulation = 40;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportTempsMaxToCSV(simulateurs[i], "results40.csv");
        }

        for (int i = 1000; i < 2000; i++) {
            Constantes.dureeSimulation = 80;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportTempsMaxToCSV(simulateurs[i], "results80.csv");
        }

        for (int i = 2000; i < 3000; i++) {
            Constantes.dureeSimulation = 160;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportTempsMaxToCSV(simulateurs[i], "results160.csv");
        }

        for (int i = 3000; i < 4000; i++) {
            Constantes.dureeSimulation = 240;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportTempsMaxToCSV(simulateurs[i], "results240.csv");
        }
    }
}