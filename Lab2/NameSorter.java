import java.util.ArrayList;
import java.util.List;

public class NameSorter {
    
    protected List<Student> selectionSort(List<Student> l) {
        int sml = Integer.MAX_VALUE;
        for (int i = 0; i < l.size(); i++) {
            sml = i;
            for (int k = i + 1; k < l.size(); k++) {
                if (l.get(k).getId() < l.get(sml).getId()) {
                    sml = k;
                }
            }
            Student temp = l.get(sml);
            l.set(sml, l.get(i));
            l.set(i, temp);
        }
        return l;
    }

    protected List<Student> insertionSort(List<Student> l) {
        for (int i = 1; i < l.size(); i++) {
            int n = l.get(i).getId();
            int j = i - 1;
            while (j >= 0 && l.get(j).getId() > n) {
                l.set(j + 1, l.get(j));
                j = j - 1; 
            }
            l.set(i + j, l.get(n));
        }
        return l;
    }

    protected List<Student> merge(List<Student> l, List<Student> r) {
        List<Student> temp = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < l.size() && right < r.size()) {
            if (l.get(left).getId() < (r.get(right).getId())) {
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

    protected List<Student> mergeSort(List<Student> l) {
        if (l.size() == 1) {
            return l;
        }
        int mid = l.size() / 2;
        return merge(mergeSort(l.subList(0, mid)), mergeSort(l.subList(mid, l.size())));
    }

    protected List<Student> bubbleSort(List<Student> l, int len) {
        if (len == 1) {
            return l;
        }
        for (int i = 0; i < len - 1; i++) {
            if (l.get(i).getId() > l.get(i + 1).getId()) {
                Student temp = l.get(i);
                l.set(i, l.get(i + 1));
                l.set(i + 1, temp);
            }
        }
        return bubbleSort(l, len - 1);
    } 
}
