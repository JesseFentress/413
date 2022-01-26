import java.util.ArrayList;
public class MinMaxDAC {
    
    protected ArrayList<Integer> minMax(ArrayList<Integer> l, ArrayList<Integer> mm) {
        if (l.size() == 1) {
            if ((int)l.get(0) < (int)mm.get(0)) {
                mm.set(0, l.get(0));
            }
            if ((int)l.get(0) > (int)mm.get(1)) {
                mm.set(1, l.get(0));
            }
            return mm;
        }
        else {
            int mid = l.size() / 2;
            mm = minMax(new ArrayList<Integer>(l.subList(0, mid)), mm);
            mm = minMax(new ArrayList<Integer>(l.subList(mid, l.size())), mm);
            return mm;
        }
    }

    protected int min(ArrayList<Integer> l, int m) {
        if (l.size() == 1) {
            if ((int)l.get(0) < m) {
                m = l.get(0);
            }
            return m;
        }
        else {
            int mid = l.size() / 2;
            m = min(new ArrayList<Integer>(l.subList(0, mid)), m);
            m = min(new ArrayList<Integer>(l.subList(mid, l.size())), m);
            return m;
        }
    }

    protected int max(ArrayList<Integer> l, int m) {
        if (l.size() == 1) {
            if ((int)l.get(0) > m) {
                m = l.get(0);
            }
            return m;
        }
        else {
            int mid = l.size() / 2;
            m = max(new ArrayList<Integer>(l.subList(0, mid)), m);
            m = max(new ArrayList<Integer>(l.subList(mid, l.size())), m);
            return m;
        }
    }
}
