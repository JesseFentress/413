import java.util.Arrays;

public class PriorityQueueArrayMax {
    
    String[] items;
    int[] priority;
    int index;
    int size;

    public PriorityQueueArrayMax() {
        this.items = new String[10];
        this.priority = new int[10];
        this.index = 0;
        this.size = 0;
    }

    public void insert(String newItem, int newItemPriority) {
        if (isFull()) {
            String[] temp = Arrays.copyOf(items, size() * 2);
            items = temp;
        }
        if (index == 0) {
            items[index] = newItem;
            priority[index] = newItemPriority;
            index++;
        }
        else {
            //index++;
            items[index] = newItem;
            priority[index] = newItemPriority;
            for (int i = index; i > 0; i--) {
                if (priority[i - 1] > priority[i]) {
                    swap(i);
                }
            }
            index++;
        }
        size++;
    }

    protected void swap(int i) {
        String tempItem = items[i - 1];
        int tempPriority = priority[i - 1];
        items[i - 1] = items[i];
        priority[i - 1] = priority[i];
        items[i] = tempItem;
        priority[i] = tempPriority;
    }

    protected String remove() {
        if (isEmpty()) {
            return null;
        }
        String temp = items[index - 1];
        items[index - 1] = null;
        priority[index - 1] = 0;
        index--;
        size--;
        return temp;
    }

    protected boolean isEmpty() {
        return size == 0;
    }
    protected boolean isFull() {
        return this.size == items.length - 1;
    }

    protected int size() {
        return this.size;
    }

    protected void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print("[" + items[i] + " " + priority[i] + "]" + " ");
        }
    }
}
