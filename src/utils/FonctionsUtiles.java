package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.List;
import java.util.Random;

import simulateur.Simulateur;
import statistique.IndicateurStatistique;

public class FonctionsUtiles {
    private static Random random = new Random();

    public static double loiExponentielle(double lambda) {
        double u = random.nextDouble();

        return -Math.log(1 - u) / lambda;
    }

    public static double loiUniforme(double a, double b) {
        double u = random.nextDouble();

        return a + u * (b - a);
    }

    public static void exportSimuToCSV(Simulateur simulateur, String nomFichier) {
        File folder = new File("./results");

        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File("./results/" + nomFichier + ".csv");

        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Erreur create file: " + e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter(file);

            fw.write("SIMULATEUR DE BUS; " + Constantes.dureeSimulation + "\n");

            fw.write("Temps d'attente moyen dans la file de controle sans les bus toujours en attente; "
                    + (IndicateurStatistique.getTpsAttenteMoyFileControle()
                            - (double) simulateur.getTempsToujoursFileCont())
                    + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation sans les bus toujours en attente; "
                    + (IndicateurStatistique.getTpsAttenteMoyFileReparation()
                            - (double) simulateur.getTempsToujoursFileRep())
                    + "\n");
            fw.write("Temps d'attente moyen dans la file de controle avec les bus toujours en attente; "
                    + IndicateurStatistique.getTpsAttenteMoyFileControle() + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation avec les bus toujours en attente; "
                    + IndicateurStatistique.getTpsAttenteMoyFileReparation() + "\n");
            fw.write("Taux d'utilisation du poste de reparation; "
                    + IndicateurStatistique.getTauxUtilisationReparation() + "\n");
            fw.write("Nombre de bus en attente dans les files; "
                    + (simulateur.getListeBusFileC().size() + simulateur.getListeBusFileR().size()) + "\n");
            fw.write("Nombre de bus total; " + simulateur.getNbBus() + "\n");
            fw.write("Taux de bus repare; "
                    + ((double) simulateur.getNbReparation() / (double) simulateur.getNbBus()) * 100 + "%" + "\n");
            fw.write("Temps max d'attente dans la file de controle; " + IndicateurStatistique.getTempsMaxAttControle()
                    + "\n");
            fw.write("Temps max d'attente dans la file de reparation; "
                    + IndicateurStatistique.getTempsMaxAttReparation() + "\n");

            fw.close();
        } catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }

    public static void exportIndStatsToCSV(Simulateur simulateur, String nomFichier) {
        File file = new File("./results/" + nomFichier);

        try {
            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);

            // Écrivez les données dans le fichier
            bw.write(IndicateurStatistique.getTpsAttenteMoyFileReparation() + ";" + IndicateurStatistique.getTpsAttenteMoyFileControle() + ";" + IndicateurStatistique.getTauxUtilisationReparation() + "\n");
            bw.write("\n");

            bw.close();

        } catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }

    public static void exportMethodeWelchToCSV(List<Double> moyennes, String nomFichier) {
        File file = new File("./results/" + nomFichier);
        if (file.exists()) {
            file.delete();
        }

        try {
            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);
            int i = 0;
            for(Double YiMobile : moyennes){
                // Écrivez les données dans le fichier
                bw.write(i+";"+YiMobile);
                bw.write("\n");
                i++;
            }



            bw.close();

        } catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }

    public static void createFoldersAndFiles() {

        File mainFolder = new File("./results");

        if (!mainFolder.exists()) {
            mainFolder.mkdir();
        }

        createFile(mainFolder, "results40.csv");
        createFile(mainFolder, "results80.csv");
        createFile(mainFolder, "results160.csv");
        createFile(mainFolder, "results240.csv");
    }

    private static void createFile(File folder, String fileName) {

        File file = new File(folder, fileName);

        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier '" + fileName + "': " + e.getMessage());
        }
    }

    public static String tempsToHeure(Double temps) {
        // Traduit le temps en pourcentage en un temps en heure
        Double tempsRes = temps;

        // Nombre d'heures est la partie entière
        int heures = tempsRes.intValue();

        // Nombre de minutes est la partie décimale * 60
        int min = (int) ((tempsRes - heures) * 60);

        return heures + " heure(s) " + min + " minute(s)";
    }
}