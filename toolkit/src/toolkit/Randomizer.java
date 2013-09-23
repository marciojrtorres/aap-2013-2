package toolkit;

public class Randomizer {

    private static long x = 1;

    private static final long a = 1664525;
    private static final long c = 1013904223;
    private static final long m = 1024;

    public static double random() {
        x = (a * x + c) % m;
        return (((double) x) / m);
    }

}