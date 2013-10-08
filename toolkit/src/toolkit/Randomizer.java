package toolkit;

public class Randomizer {

    private static long x = System.currentTimeMillis();

    private static final long A = 1664525;
    private static final long C = 1013904223;
    private static final long M = 1024;

    public static double random() {
        x = (A * x + C) % M;
        return ((double) x) / M;
    }

}