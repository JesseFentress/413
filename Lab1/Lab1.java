import java.util.ArrayList;
import java.util.Arrays;
class Lab1 {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int n1 = 564;
        int n2 = 34;
        MinMaxFinder m1 = new MinMaxFinder();
        MinMaxDAC m2 = new MinMaxDAC();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 342, 90, 0, -234, 345, 33, 945, -42, -2, 4, 184));
        long start = System.nanoTime();
        System.out.println("GCD (" + n1 + ", " + n2 + "): " + gcd.gcd(n1, n2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Min: " + m1.min(al, 0, (int) Integer.MAX_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Max: " + m1.max(al, 0, (int) Integer.MIN_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Min & Max: " +
                m2.minMax(al, new ArrayList<Integer>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE))));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
    }
}
