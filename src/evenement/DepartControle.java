package evenement;

import ressource.Variable;
import utils.FonctionsUtiles;
import echeancier.Echeancier;

public class DepartControle implements Evenement {
    @Override public void lancerEvenement() {
        Variable.statusControle = false;

        if (Variable.queueControle > 0){
            Echeancier.insererEcheancier(new AccesControle(), Echeancier.tpsSimulation);
        }
        else {
            if (FonctionsUtiles.doitReparer()){
                Echeancier.insererEcheancier(new ArriveeFileR(), Echeancier.tpsSimulation);
            }
            
        }
    }

    public DepartControle() {
        lancerEvenement();
    }
}