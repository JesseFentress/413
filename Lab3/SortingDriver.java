import java.util.ArrayList;
import java.util.Random;

public class SortingDriver {
    public static void main(String[] args) {
        Random random = new Random();
        Sorts sorter = new Sorts();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < 100000; i++) {
            if (i < 50000) {
                list1.add(random.nextInt(9999));
            }
            list2.add(random.nextInt(9999));
        }
        long start;

        start = System.currentTimeMillis();
        sorter.countingSort(list2);
        System.out.println("Count Sort (100k) Elapsed Time: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        sorter.countingSort(list1);
        System.out.println("Count Sort (50k) Elapsed Time: " + (System.currentTimeMillis() - start));
    }
}
