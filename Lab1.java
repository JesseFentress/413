import java.util.ArrayList;
/*public class MinMaxFinder {
    
    protected int[] minMax(int[] arr) {
        int[] mm = {arr[0], arr[0]};
        for (int item: arr) {
            if (item < mm[0]) {
                mm[0] = item;
            }
            if (item > mm[1]) {
                mm[1] = item;
            }
        }
        return mm;
    }
} */

class Lab1 {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        gcd.gcd(56, 19);
        System.out.println(gcd.gcd(56, 19));
        // MinMaxFinder mm = MinMaxFinder();
        MergeSort mg = new MergeSort();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(342);
        al.add(0);
        al.add(-234);
        al.add(23);
        al.add(99);
        al.add(13);
        al.add(8);
        al.add(175);
        //mg.mergeSort(al);
        for (Integer item: mg.mergeSort(al)) {
            System.out.println(item);
        }
    }
}