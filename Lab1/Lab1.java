import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
class Lab1 {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int n1 = 564;
        int n2 = 34;
        MinMaxFinder m1 = new MinMaxFinder();
        MinMaxDAC m2 = new MinMaxDAC();
        Random r = new Random();
        Integer[] arr1000 = new Integer[1000];
        Integer[] arr10000 = new Integer[10000];
        for (int i = 0; i < 1000; i++) {
            arr1000[i] = r.nextInt(100000);
        }
        for (int i = 0; i < 10000; i++) {
            arr10000[i] = r.nextInt(100000);
        }
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr1000));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(arr10000));
        
        // GCD
        long start = System.nanoTime();
        System.out.println("GCD (" + n1 + ", " + n2 + "): " + gcd.gcd(n1, n2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        
        // Recursive Min/Max 1000 Elements
        start = System.nanoTime();
        System.out.println("Recursive Min (1000): " + m1.min(al, 0, (int)Integer.MAX_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Recursive Max (1000): " + m1.max(al, 0, (int)Integer.MIN_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        /*// Recursive Min/Max 10000 Elements
        start = System.nanoTime();
        System.out.println("Recursive Min (10000): " + m1.min(al2, 0, (int)Integer.MAX_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println(" Recursive Max (10000): " + m1.max(al2, 0, (int)Integer.MIN_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();*/

        // Min/Max 1000 Elements
        start = System.nanoTime();
        System.out.println("Min (1000): " + m1.mi(al));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Max (1000): " + m1.ma(al));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        // Min/Max 10000 Elements
        start = System.nanoTime();
        System.out.println("Min (10000): " + m1.mi(al2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("Max (10000): " + m1.ma(al2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        
        // Min/Max Divide and Conquer 1000 Elements
        start = System.nanoTime();
        System.out.println("DAC Min & Max (1000): " +
                m2.minMax(al, new ArrayList<Integer>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE))));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        // Min/Max Divide and Conquer 10000 Elements
        start = System.nanoTime();
        System.out.println("DAC Min & Max (10000): " +
                m2.minMax(al2, new ArrayList<Integer>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE))));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns"); 
        System.out.println();

        // Min/Max Divide and Conquer 1000 Elements
        start = System.nanoTime();
        System.out.println("DAC Min (1000): " +
                m2.min(al, (int)Integer.MAX_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        start = System.nanoTime();
        System.out.println("DAC Max (1000): " +
                m2.max(al, (int)Integer.MIN_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        // Min/Max Divide and Conquer 10000 Elements
        start = System.nanoTime();
        System.out.println("DAC Min (10000): " +
                m2.min(al2, (int)Integer.MAX_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns"); 
        start = System.nanoTime();
        System.out.println("DAC Max (10000): " +
                m2.max(al2, (int)Integer.MIN_VALUE));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns"); 
        System.out.println();
    }
}
