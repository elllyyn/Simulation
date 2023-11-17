package simulateur;

import java.util.ArrayList;

import echeancier.Echeancier;
import entite.Bus;
import evenement.DebutSimulation;
import evenement.Evenement;
import statistique.IndicateurStatistique;
import utils.Constantes;

public class Simulateur {
    private boolean statusControle;
    private byte statusReparation;
    private int nbBus;
    private int nbReparation;
    private ArrayList<Bus> listeBusFileC;
    private ArrayList<Bus> listeBusFileR;
    private ArrayList<Bus> listeBusSysteme;;
    private Echeancier echeancier;
    private double tempsSimulation;

    public Simulateur() {
        statusControle = false;
        statusReparation = 0;
        nbBus = 0;
        nbReparation = 0;
        tempsSimulation = 0;
        listeBusFileC = new ArrayList<Bus>();
        listeBusFileR = new ArrayList<Bus>();
        listeBusSysteme = new ArrayList<Bus>();
        echeancier = new Echeancier();
    }

    public boolean getStatusControle() {
        return statusControle;
    }

    public void setStatusControle(boolean statusControle) {
        this.statusControle = statusControle;
    }

    public byte getStatusReparation() {
        return statusReparation;
    }

    public void setStatusReparation(byte statusReparation) {
        if (statusReparation == 0 || statusReparation == 1 || statusReparation == 2)
            this.statusReparation = statusReparation;
        else
            System.out.println("Erreur : statusReparation doit être 0, 1 ou 2");
    }

    public int getNbBus() {
        return nbBus;
    }

    public void setNbBus(int nbBus) {
        this.nbBus = nbBus;
    }

    public int getNbReparation() {
        return nbReparation;
    }

    public void setNbReparation(int nbReparation) {
        this.nbReparation = nbReparation;
    }

    public ArrayList<Bus> getListeBusFileC() {
        return listeBusFileC;
    }

    public ArrayList<Bus> getListeBusFileR() {
        return listeBusFileR;
    }

    public ArrayList<Bus> getListeBusSysteme() {
        return listeBusSysteme;
    }

    public Echeancier getEcheancier() {
        return echeancier;
    }

    public void addBusSysteme(Bus bus) {
        listeBusSysteme.add(bus);
    }

    public void addBusFileC(Bus bus) {
        listeBusFileC.add(bus);
    }

    public void addBusFileR(Bus bus) {
        listeBusFileR.add(bus);
    }

    public void removeBusSysteme(Bus bus) {
        listeBusSysteme.remove(bus);
    }

    public void removeBusFileC(Bus bus) {
        listeBusFileC.remove(bus);
    }

    public void removeBusFileR(Bus bus) {
        listeBusFileR.remove(bus);
    }

    public void addEventEcheancier(Evenement event) {
        echeancier.insererEcheancier(event);
    }

    public void lancerSimulation() {
        addEventEcheancier(new DebutSimulation(0, new Bus()));

        while (echeancier.getTaille() > 0) {
            Evenement event = echeancier.retirerEcheancier();
            event.lancerEvenement(this);
            majDesAires(event.getTemps(), tempsSimulation);
            tempsSimulation = event.getTemps();
        }
    }

    public double getTempsMaxAttControle(){
        double tempsMax = 0;
        for (Bus bus : listeBusSysteme) {
            double tempsAttControle = bus.getTempsSortieFileCont() - bus.getTempsEntreeFileCont();
            if (tempsAttControle > tempsMax) {
                tempsMax = tempsAttControle;
            }
        }
        return tempsMax;
    }

    public double getTempsMaxAttRep(){
        double tempsMax = 0;
        for (Bus bus : listeBusSysteme) {
            double tempsAttRep = bus.getTempsSortieFileRep() - bus.getTempsEntreeFileRep();
            if (tempsAttRep > tempsMax) {
                tempsMax = tempsAttRep;
            }
        }
        return tempsMax;
    }

    public double getTempsAttToujoursFileCont(){
        double tempsAtt = 0;
        for (Bus bus : listeBusSysteme) {
            if (bus.getTempsSortieFileCont() == 0) {
                tempsAtt += Constantes.dureeSimulation - bus.getTempsEntreeFileCont();
            }
        }
        return tempsAtt;
    }

    public double getTempsAttToujoursFileRep(){
        double tempsAtt = 0;
        for (Bus bus : listeBusSysteme) {
            if (bus.getTempsSortieFileRep() == 0 && bus.getTempsEntreeFileRep() != 0) {
                tempsAtt += Constantes.dureeSimulation - bus.getTempsEntreeFileRep();
            }
        }
        
        return tempsAtt;
    }

    public void majDesAires(double temps2, double temps1){
        IndicateurStatistique.setAireQueueControle(IndicateurStatistique.getAireQueueControle() + (temps2 - temps1) * listeBusFileC.size());
        IndicateurStatistique.setAireQueueReparation(IndicateurStatistique.getAireQueueReparation() + (temps2 - temps1) * listeBusFileR.size());
        IndicateurStatistique.setAirePosteReparation(IndicateurStatistique.getAirePosteReparation() + (temps2 - temps1) * statusReparation);
    }
}