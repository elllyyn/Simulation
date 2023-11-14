package echeancier;

import java.util.List;
import evenement.Evenement;

public class Echeancier {

    public static int tpsSimulation;
    public static List<Evenement> evenements;

    public static boolean insererEcheancier(Evenement e, int tps) {
        tpsSimulation = tps;
        return evenements.add(e);
    }

    public static Evenement retirerEcheancier() {
        return evenements.remove(0);
    }
}