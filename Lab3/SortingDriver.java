import java.util.ArrayList;
import java.util.Random;

public class SortingDriver {
    public static void main(String[] args) {
        Random random = new Random();
        Sorts sorter = new Sorts();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < 100000; i++) {
            while (i < 49999) {
                list1.add(random.nextInt(1000));
            }
            list2.add(random.nextInt(1000));
        }

        
    }
}
