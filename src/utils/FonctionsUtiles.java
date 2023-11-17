package utils;
import java.lang.Math;
import java.util.Random;

public class FonctionsUtiles {
    private static Random random = new Random();

    public static double loiExponentielle(double lambda) {
        double u = random.nextDouble();
        
        return -Math.log(1 - u) / lambda;
    }

    public static double loiUniforme(double a, double b) {
        double u = random.nextDouble();
        
        return a + u * (b - a);
    }
}