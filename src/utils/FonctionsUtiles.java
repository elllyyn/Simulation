package utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.Math;
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

    public static void exportSimuToCSV(Simulateur simulateur, String nomFichier){
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

            fw.write("Temps d'attente moyen dans la file de controle sans les bus toujours en attente; " + (IndicateurStatistique.getTpsAttenteMoyFileControle() - (double)simulateur.getTempsToujoursFileCont()) + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation sans les bus toujours en attente; " + (IndicateurStatistique.getTpsAttenteMoyFileReparation() - (double)simulateur.getTempsToujoursFileRep()) + "\n");
            fw.write("Temps d'attente moyen dans la file de controle avec les bus toujours en attente; " + IndicateurStatistique.getTpsAttenteMoyFileControle() + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation avec les bus toujours en attente; " + IndicateurStatistique.getTpsAttenteMoyFileReparation() + "\n");
            fw.write("Taux d'utilisation du poste de reparation; " + IndicateurStatistique.getTauxUtilisationReparation() + "\n");
            fw.write("Nombre de bus en attente dans les files; " + (simulateur.getListeBusFileC().size() + simulateur.getListeBusFileR().size()) + "\n");
            fw.write("Nombre de bus total; " + simulateur.getNbBus() + "\n");
            fw.write("Taux de bus repare; " + ((double)simulateur.getNbReparation() / (double)simulateur.getNbBus()) * 100 + "%" + "\n");
            fw.write("Temps max d'attente dans la file de controle; " + IndicateurStatistique.getTempsMaxAttControle() + "\n");
            fw.write("Temps max d'attente dans la file de reparation; " + IndicateurStatistique.getTempsMaxAttReparation() + "\n");

            fw.close();
        }
        catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }

    public static void exportIndStatsToCSV(Simulateur simulateur, String nomFichier){
        File file = new File("./results/" + nomFichier);

        try{
            // Utilisez le constructeur FileWriter avec le deuxième argument pour append (true)
            FileWriter fw = new FileWriter(file, true);

            // Utilisez BufferedWriter pour améliorer les performances d'écriture
            BufferedWriter bw = new BufferedWriter(fw);

            // Écrivez les données dans le fichier
            bw.write(IndicateurStatistique.getTpsAttenteMoyFileReparation() + "\n");
            bw.write(IndicateurStatistique.getTpsAttenteMoyFileControle() + "\n");
            bw.write(IndicateurStatistique.getTauxUtilisationReparation() + "\n\n");

            // Fermez BufferedWriter pour s'assurer que toutes les données sont écrites dans le fichier
            bw.close();
        
        } catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }

    public static void createFoldersAndFiles() {
        File folder = new File("./results");

        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File("./results/results40.csv");
        File file2 = new File("./results/results80.csv");
        File file3 = new File("./results/results160.csv");
        File file4 = new File("./results/results240.csv");

        if (file.exists()) {
            file.delete();
        }

        if (file2.exists()) {
            file2.delete();
        }

        if (file3.exists()) {
            file3.delete();
        }

        if (file4.exists()) {
            file4.delete();
        }

        try {
            file.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
        } catch (Exception e) {
            System.out.println("Erreur create file: " + e.getMessage());
        }
    }

    public static String tempsToHeure(Double temps) {
        // Traduit le temps en pourcentage en un temps en heure
        Double tempsRes = 60 * temps;

        // Calcule le nombre d'heures & de minutes
        Double min = tempsRes % 60;
        int heures = (int)(tempsRes % 60 - min);

        // Retourne un affichage au bon format
        return heures + " heure(s) "+min+" minute(s)";
    }
}