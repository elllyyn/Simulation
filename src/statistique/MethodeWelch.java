package statistique;

import utils.Constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodeWelch {
    //numero simulation et temps attente des Bus
    private static Map<Integer,List<Double>> tempsAttenteBusParSimulation = new HashMap<Integer,List<Double>>();

    private static int numSimulateur = 0;

    public final static int nbReplication = 10;

    public MethodeWelch(){
    }
    public static List<Double> appliquerMethode(int w){
        List<Double> moyennesEstimees = calculerMoyenneEstimee();
        return calculerMoyenneMobiles(moyennesEstimees, w);
    }
    private static List<Double> calculerMoyenneEstimee(){
        List<Double> moyenneEstimee = new ArrayList<>();
        for(int i = 0; i < Constantes.nbBusMaxControle; i++){
            double Yi = 0;
            for(int j = 0; j < nbReplication; j++){
                Yi += tempsAttenteBusParSimulation.get(j).get(i);
            }
            moyenneEstimee.add(Yi/nbReplication);
        }
        return moyenneEstimee;
    }

    private static List<Double> calculerMoyenneMobiles(List<Double> moyennesEstimees, int w){
        List<Double> moyennesMobiles = new ArrayList<>();
        for(int i = 0; i < Constantes.nbBusMaxControle; i++){
            double YiMobile = 0;
            int taille = 0;

            for(int k = -w; k <= w ; k++){
                if(i+k >= 0 && i+k < Constantes.nbBusMaxControle){
                    YiMobile += moyennesEstimees.get(i+k);
                    taille++;
                }
            }
            YiMobile = YiMobile / taille;

            moyennesMobiles.add(YiMobile);
        }
        return moyennesMobiles;
    }

    public static void ajouterTempsAttente(double tempsAttenteBus){
        if(tempsAttenteBusParSimulation.containsKey(numSimulateur)){
            tempsAttenteBusParSimulation.get(numSimulateur).add(tempsAttenteBus);
        }else{
            tempsAttenteBusParSimulation.put(numSimulateur, new ArrayList<Double>());
        }
    }

    public static void setNumSimulateur(int numSimulateur) {
        MethodeWelch.numSimulateur = numSimulateur;
    }

    public static int getNumSimulateur() {
        return numSimulateur;
    }
}

