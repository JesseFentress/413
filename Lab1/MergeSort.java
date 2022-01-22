import java.util.ArrayList;
public class MergeSort {
    
    private ArrayList<Integer> merge(ArrayList<Integer> l, ArrayList<Integer> r) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = 0, right = 0;
        while (left < l.size() && right < r.size()) {
            if (l.get(left) < r.get(right)) {
                temp.add(l.get(left));
                left++;
            }
            else {
                temp.add(r.get(right));
                right++;
            }
        }
        temp.addAll(l.subList(left, -1));
        temp.addAll(r.subList(right, -1));
        return temp;
    }

    protected ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() == 1){
            return list;
        }
        int mid = list.size() / 2;
        return merge(mergeSort(new ArrayList<Integer>(list.subList(0, mid))), mergeSort(new ArrayList<Integer>(list.subList(mid, list.size()- 1))));
    }
}
