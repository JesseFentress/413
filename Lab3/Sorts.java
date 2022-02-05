import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorts {

    protected List<Integer> merge(List<Integer> l, List<Integer> r) {
        List<Integer> temp = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < l.size() && right < r.size()) {
            if (l.get(left) < (r.get(right))) {
                temp.add(l.get(left));
                left++;
            }
            else {
                temp.add(r.get(right));
                right++;
            }
        }
        temp.addAll(l.subList(left, l.size()));
        temp.addAll(r.subList(right,r.size()));
        return temp;
    }

    protected List<Integer> mergeSort(List<Integer> l) {
        if (l.size() == 1) {
            return l;
        }
        int mid = l.size() / 2;
        return merge(mergeSort(l.subList(0, mid)), mergeSort(l.subList(mid, l.size())));
    }

    protected List<Integer> countingSort(List<Integer> arr) {
            Integer[] freq = new Integer[100];
            //Arrays.fill(freq, 0);
            for (int i = 0; i < arr.size(); i++) {
                freq[arr.get(i)] = freq[arr.get(i)] + 1;
            }
            for (int i = 0; i < freq.length; i++) {
                for (int k = i; i <= freq[i]; k++) {
                    arr.set(k,freq[i]);
                }
            }
            return arr;
    }

    protected List<Integer> quickSort(List<Integer> l) {
        return l;
    }
    
    
}
