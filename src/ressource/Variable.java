package ressource;

public class Variable {
    public static boolean statusControle;
    public static byte statusReparartion;
    public static int nbBus;
    public static int nbReparation;
    public static int queueControle;
    public static int queueReparation;

    public static final byte lambdaArriveeBus = 45;
    public static final int tempsMinControle = 15;
    public static final int tempsMaxControle = 65;
    public static final int tempsMinReparation = 168;
    public static final int tempsMaxReparation = 330;
    public static final int tempsSimulation = 160 * 60;

    public static void initialiser() {
        statusControle = false;
        statusReparartion = 0;
        nbBus = 0;
        nbReparation = 0;
        queueControle = 0;
        queueReparation = 0;
    }
}
