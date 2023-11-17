package echeancier;

import java.util.ArrayList;
import java.util.List;
import evenement.Evenement;

public class Echeancier extends ArrayList<Evenement> {

    public Echeancier() {
        super();
    }

    public boolean insererEcheancier(Evenement e) {
        byte boucle;

        for (boucle = 0; boucle < size(); boucle++) {
            if (e.compareTo(get(boucle)) < 0) {
                add(boucle, e);
                return true;
            }
        }
        add(e);
        return false;
    }

    public Evenement retirerEcheancier() {
        System.out.println("Evement retire : " + get(0).getClass().getName() + " a la date " + get(0).getTemps());
        return remove(0);
    }

    public Evenement getEvenement(int index) {
        return get(index);
    }

    public int getTaille() {
        return size();
    }

    public List<Evenement> getEvenements() {
        return this;
    }
}
