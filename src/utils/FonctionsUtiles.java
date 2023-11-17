package utils;
import java.lang.Math;

public class FonctionsUtiles {
    public static double loiExponentielle(double lambda) {
        return -Math.log(Math.random()) / lambda;
    }

    public static double loiUniforme(double a, double b) {
        return a + (b - a) * Math.random();
    }
}
