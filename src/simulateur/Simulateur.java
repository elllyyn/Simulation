package simulateur;

import java.util.ArrayList;

import echeancier.Echeancier;
import entite.Bus;
import evenement.DebutSimulation;
import evenement.Evenement;
import evenement.FinSimulation;
import statistique.IndicateurStatistique;
import utils.Constantes;

public class Simulateur {
    private boolean statusControle;
    private byte statusReparation;
    private int nbBus;
    private int nbReparation;
    private ArrayList<Bus> listeBusFileC;
    private ArrayList<Bus> listeBusFileR;
    private Echeancier echeancier;
    private double tempsSimulation;
    private int nbBusAccesControle;

    public Simulateur() {
        statusControle = false;
        statusReparation = 0;
        nbBus = 0;
        nbReparation = 0;
        tempsSimulation = 0;
        listeBusFileC = new ArrayList<Bus>();
        listeBusFileR = new ArrayList<Bus>();
        echeancier = new Echeancier();
    }

    public void clear() {
        statusControle = false;
        statusReparation = 0;
        nbBus = 0;
        nbReparation = 0;
        tempsSimulation = 0;
        listeBusFileC = new ArrayList<Bus>();
        listeBusFileR = new ArrayList<Bus>();
        echeancier = new Echeancier();
    }

    public boolean getStatusControle() {
        return statusControle;
    }

    public void setStatusControle(boolean statusControle) {
        this.statusControle = statusControle;
    }

    public int getNbBusAccesControle() {
        return nbBusAccesControle;
    }

    public void setNbBusAccesControle(int nbBusAccesControle) {
        this.nbBusAccesControle = nbBusAccesControle;
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

    public Echeancier getEcheancier() {
        return echeancier;
    }

    public void addBusFileC(Bus bus) {
        listeBusFileC.add(bus);
    }

    public void addBusFileR(Bus bus) {
        listeBusFileR.add(bus);
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
        clear();
        IndicateurStatistique.clear();
        System.out.println();
        System.out.println("----------LANCEMENT SIMUALTION "+Constantes.dureeSimulation+"H----------");
        addEventEcheancier(new DebutSimulation(0, new Bus()));

        while (nbBusAccesControle < Constantes.nbBusControle) {
            Evenement event = echeancier.retirerEcheancier();
            majDesAires(event.getTemps(), tempsSimulation);
            tempsSimulation = event.getTemps();
            event.lancerEvenement(this);
        }

        addEventEcheancier(new FinSimulation(tempsSimulation, new Bus()));
        Evenement event = echeancier.retirerEcheancier();
        majDesAires(event.getTemps(), tempsSimulation);
        tempsSimulation = event.getTemps();
        event.lancerEvenement(this);
    }

    public double getTempsToujoursFileCont()
    {
        double temps = 0;
        for (Bus bus : listeBusFileC) {
            temps += Constantes.dureeSimulation - bus.getTempsEntreeFileCont();
        }
        return temps / nbBus;
    }

    public double getTempsToujoursFileRep()
    {
        double temps = 0;
        for (Bus bus : listeBusFileR) {
            temps += Constantes.dureeSimulation - bus.getTempsEntreeFileRep();
        }
        return temps / nbBus;
    }

    public void majDesAires(double temps2, double temps1){
        IndicateurStatistique.setAireQueueControle(IndicateurStatistique.getAireQueueControle() + (temps2 - temps1) * listeBusFileC.size());
        IndicateurStatistique.setAireQueueReparation(IndicateurStatistique.getAireQueueReparation() + (temps2 - temps1) * listeBusFileR.size());
        IndicateurStatistique.setAirePosteReparation(IndicateurStatistique.getAirePosteReparation() + (temps2 - temps1) * statusReparation);
    }
}