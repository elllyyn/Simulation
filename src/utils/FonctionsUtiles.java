package utils;
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

            fw.write("SIMULATEUR DE BUS, " + Constantes.dureeSimulation + "\n");

            fw.write("Temps d'attente moyen dans la file de controle sans les bus toujours en attente, " + (IndicateurStatistique.getTpsAttenteMoyFileControle() - (double)simulateur.getTempsToujoursFileCont()) + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation sans les bus toujours en attente, " + (IndicateurStatistique.getTpsAttenteMoyFileReparation() - (double)simulateur.getTempsToujoursFileRep()) + "\n");
            fw.write("Temps d'attente moyen dans la file de controle avec les bus toujours en attente, " + IndicateurStatistique.getTpsAttenteMoyFileControle() + "\n");
            fw.write("Temps d'attente moyen dans la file de reparation avec les bus toujours en attente, " + IndicateurStatistique.getTpsAttenteMoyFileReparation() + "\n");
            fw.write("Taux d'utilisation du poste de reparation, " + IndicateurStatistique.getTauxUtilisationReparation() + "\n");
            fw.write("Nombre de bus en attente dans les files, " + (simulateur.getListeBusFileC().size() + simulateur.getListeBusFileR().size()) + "\n");
            fw.write("Nombre de bus total, " + simulateur.getNbBus() + "\n");
            fw.write("Taux de bus repare, " + ((double)simulateur.getNbReparation() / (double)simulateur.getNbBus()) * 100 + "%" + "\n");
            fw.write("Temps max d'attente dans la file de controle, " + IndicateurStatistique.getTempsMaxAttControle() + "\n");
            fw.write("Temps max d'attente dans la file de reparation, " + IndicateurStatistique.getTempsMaxAttReparation() + "\n");

            fw.close();
        }
        catch (Exception e) {
            System.out.println("Erreur write file: " + e.getMessage());
        }
    }
}