package entite;

public class Bus {
    private double tempsEntreeFileCont;
    private double tempsSortieFileCont;
    private double tempsEntreeFileRep;
    private double tempsSortieFileRep;

    public Bus(){
        this.tempsEntreeFileCont = 0;
        this.tempsSortieFileCont = 0;
        this.tempsEntreeFileRep = 0;
        this.tempsSortieFileRep = 0;
    }

    public double getTempsEntreeFileCont() {
        return tempsEntreeFileCont;
    }

    public void setTempsEntreeFileCont(double tempsEntreeFileCont) {
        this.tempsEntreeFileCont = tempsEntreeFileCont;
    }

    public double getTempsSortieFileCont() {
        return tempsSortieFileCont;
    }

    public void setTempsSortieFileCont(double tempsSortieFileCont) {
        this.tempsSortieFileCont = tempsSortieFileCont;
    }

    public double getTempsEntreeFileRep() {
        return tempsEntreeFileRep;
    }

    public void setTempsEntreeFileRep(double tempsEntreeFileRep) {
        this.tempsEntreeFileRep = tempsEntreeFileRep;
    }

    public double getTempsSortieFileRep() {
        return tempsSortieFileRep;
    }

    public void setTempsSortieFileRep(double tempsSortieFileRep) {
        this.tempsSortieFileRep = tempsSortieFileRep;
    }
}
