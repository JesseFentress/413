import java.util.List;

public class MinMaxFinder {
    protected int min(List<Integer> list, int index, int min) {
        if (index == list.size()) {
            return min;
        }
        else {
            if ((int)list.get(index) < min) {
                min = (int)list.get(index);
            }
            min = min(list, index + 1, min);
            return min;
        }
    }

    protected int max(List<Integer> list, int index, int max) {
        if (index == list.size()) {
            return max;
        }
        else {
            if ((int)list.get(index) > max) {
                max = (int)list.get(index);
            }
            max = max(list, index + 1, max);
            return max;
        }
    }

    protected int mi(List<Integer> list) {
        int min = Integer.MAX_VALUE; 
        for (int i = 0; i < list.size(); i++) {
            if ((int)list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    protected int ma(List<Integer> list) {
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < list.size(); i++) {
            if ((int)list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
