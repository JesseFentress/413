import java.util.List;

public class MinMaxFinder {
    protected <T> int min(List<Integer> list, int index, int min) {
        if (index == list.size() - 1) {
            if ((int)list.get(index) < min) {
                min = (int)list.get(index);
            }
            return min;
        }
        else {
            if ((int)list.get(index) < min) {
                return min(list, index + 1, (int)list.get(index));
            }
            else {
                return min(list, index + 1, min);
            }
        }
    }

    protected <T> int max(List<Integer> list, int index, int max) {
        if (index == list.size() - 1) {
            if ((int)list.get(index) > max) {
                max = (int)list.get(index);
            }
            return max;
        }
        else {
            if ((int)list.get(index) > max) {
                return max(list, index + 1, (int)list.get(index));
            }
            else {
                return max(list, index + 1, max);
            }
        }
    }
}
