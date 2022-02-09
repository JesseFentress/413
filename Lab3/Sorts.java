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
        Integer[] freq = new Integer[10000];
        int index = 0;
        Arrays.fill(freq, 0);
        for (int i = 0; i < arr.size(); i++) {
            freq[arr.get(i)] = freq[arr.get(i)] + 1;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int k = 0; k < freq[i]; k++) {
                    arr.set(index, i);
                    index++;
                }
            }
        }
        return arr;
    }

    protected int partition(List<Integer> arr, int low, int high) {
        int index = low - 1;
        for (int i = low; i < high; i++) {
            if (arr.get(i) < arr.get(high)) {
                index++;
                int temp = arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, temp);
            }
        }
        int temp = arr.get(high);
        arr.set(high, arr.get(index + 1));
        arr.set(index + 1, arr.get(high));
        return index + 1;
    }


    protected void quickSort(List<Integer> arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

}
