package evenement;

import echeancier.Echeancier;
import ressource.Variable;

public class ArriveeFileR implements Evenement {
    @Override public void lancerEvenement() {
        Variable.queueReparation++;
        Variable.nbReparation++;
        
        if (Variable.statusReparartion < 2){
            Echeancier.insererEcheancier(new AccesReparation(), Echeancier.tpsSimulation);
        }
    }
    
    public ArriveeFileR() {
        lancerEvenement();
    }
}