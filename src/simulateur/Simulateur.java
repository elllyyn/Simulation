package simulateur;

import java.util.ArrayList;

import echeancier.Echeancier;
import entite.Bus;
import evenement.DebutSimulation;
import evenement.Evenement;

public class Simulateur {
    private boolean statusControle;
    private byte statusReparation;
    private int nbBus;
    private int nbReparation;
    private ArrayList<Bus> listeBusFileC;
    private ArrayList<Bus> listeBusFileR;
    private ArrayList<Bus> listeBusSysteme;;
    private Echeancier echeancier;

    public Simulateur() {
        statusControle = false;
        statusReparation = 0;
        nbBus = 0;
        nbReparation = 0;
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
            echeancier.retirerEcheancier().lancerEvenement(this);
        }
    }
}