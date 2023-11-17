package evenement;

import entite.Bus;
import simulateur.Simulateur;

public abstract class Evenement implements Comparable<Evenement> {
    private double temps;
    private Bus bus;

    public abstract void lancerEvenement(Simulateur simulateur);

    public Evenement(double temps, Bus bus) {
        this.temps = temps;
        this.bus = bus;
    }

    public double getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    @Override
    public int compareTo(Evenement evenement) {
        return Double.compare(temps, evenement.getTemps());
    }

    public Bus getBus() {
        return bus;
    }
}