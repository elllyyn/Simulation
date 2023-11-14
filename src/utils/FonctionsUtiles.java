package utils;
import java.lang.Math;

public class FonctionsUtiles {
    public static double loiExponentielle(double lambda) {
        return -Math.log(Math.random()) / lambda;
    }

    public static double loiUniforme(int a, int b) {
        return a + (b - a) * Math.random();
    }

    public static boolean doitReparer() {
        return Math.random() <= 0.3;
    }
}