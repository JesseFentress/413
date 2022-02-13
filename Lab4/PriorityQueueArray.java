import java.util.Arrays;

public class PriorityQueueArray<T> {

    T[] items;
    int[] priority;
    String m;
    int index = 0;

    public PriorityQueue(int size, String m) {
        items = new T[size];
        this.m = m;
    }

    protected T peek() {
        T temp;
        switch (m) {
            case "min":
                int min = Integer.MAX_VALUE;
                for (T item: arr) {
                    
                }
                break;
            case "max":
                int max = Integer.MIN_VALUE;
                for (T item: arr) {

                }
                break;
        } 
        return temp;
    }

    protected insert(T item, int priority) {
        if (isFull()) {
            T[] temp = Arrays.copyOf(arr, size() * 2);
            arr = temp;
        }
        
        
    }

    protected T remove() {
        T top = peek();
        while ()
        return top;
    }

    protected void changePriority(T item, String newPriority) {

    }

    protected boolean isFull() {
        return index >= items.length;
    }

    protected int size() {
        return items.length;
    }    
}
