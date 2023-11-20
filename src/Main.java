import simulateur.Simulateur;
import utils.FonctionsUtiles;
import utils.Constantes;

public class Main {
    public static void main(String[] args) {
        //Tableau de 1000 simulateurs
        Simulateur[] simulateurs = new Simulateur[4000];
        FonctionsUtiles.createFoldersAndFiles();

        for (int i = 0; i < 1000; i++) {
            Constantes.dureeSimulation = 40;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results40.csv");
        }

        for (int i = 1000; i < 2000; i++) {
            Constantes.dureeSimulation = 80;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results80.csv");
        }

        for (int i = 2000; i < 3000; i++) {
            Constantes.dureeSimulation = 160;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results160.csv");
        }

        for (int i = 3000; i < 4000; i++) {
            Constantes.dureeSimulation = 240;
            simulateurs[i] = new Simulateur();
            simulateurs[i].lancerSimulation();
            FonctionsUtiles.exportIndStatsToCSV(simulateurs[i], "results240.csv");
        }
    }
}