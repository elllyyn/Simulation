package echeancier;

import java.util.ArrayList;
import java.util.List;
import evenement.Evenement;

public class Echeancier {
    private List<Evenement> evenements = new ArrayList<Evenement>();

    public boolean insererEcheancier(Evenement e) {
        byte boucle;

        for (boucle = 0; boucle < evenements.size(); boucle++) {
            if (e.compareTo(evenements.get(boucle)) < 0) {
                evenements.add(boucle, e);
                return true;
            }
        }
        evenements.add(e);
        return false;
    }

    public Evenement retirerEcheancier() {
        System.out.println("Evement retire : " + evenements.get(0).getClass().getName() + " à la date " + evenements.get(0).getTemps());
        return evenements.remove(0);
    }

    public Evenement getEvenement(int index) {
        return evenements.get(index);
    }

    public int getTaille() {
        return evenements.size();
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }
}