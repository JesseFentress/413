import java.util.Arrays;

public class PriorityQueueArray<T> {

    T[] items;
    int[] priority;
    String m;
    int index = 0;

    public PriorityQueueArray(int size, String m) {
        this.items = new T[size];
        this.m = m;
    }

    protected T peek() {
        if (isEmpty()) {
            return null;
        }
        int index = 0;
        switch (m) {
            case "min":
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < priority.length; i++) {
                    if (priority[i] < min) {
                        min = priority[i];
                        index = i;
                    }
                }
                break;
            case "max":
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < priority.length; i++) {
                    if (priority[i] > max) {
                        min = priority[i];
                        index = i;
                    }
                }
                break;
        } 
        return items[index];
    }

    protected void insert(T item, int prio) {
        if (isFull()) {
            T[] temp = Arrays.copyOf(items, size() * 2);
            items = temp;
        }
        items[index] = item;
        priority[index] = prio;
        index++;    
    }

    protected T remove() {
        T top = peek();    
        return top;
    }

    protected void changePriority(T item, String newPriority) {

    }

    protected boolean isFull() {
        return index >= size();
    }

    protected boolean isEmpty() {
        return size() == 0;
    }

    protected int size() {
        return items.length;
    }    
}
