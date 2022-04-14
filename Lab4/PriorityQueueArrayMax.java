import java.util.Arrays;

public class PriorityQueueArrayMax {
    
    String[] items;
    int[] priority;
    int index;
    int size;

    public PriorityQueueArrayMax() {
        this.items = new String[10];
        this.priority = new int[10];
        this.index = -1;
        this.size = 0;
    }

    public void insert(String newItem, int newItemPriority) {
        if (isFull()) {
            String[] temp = Arrays.copyOf(items, size() * 2);
            items = temp;
        }
        if (index == -1) {
            index++;
            items[index] = newItem;
            priority[index] = newItemPriority;
        }
        else {
            for (int i = index - 1; i >= 0; i--) {
                if (priority[i] <= newItemPriority) {
                    items[i + 1] = items[i];
                    priority[i + 1] = priority[i];
                    items[i] = newItem;
                    priority[i] = newItemPriority;
                }
                else {
                    items[i + 1] = newItem;
                    priority[i + 1] = newItemPriority;
                    break;
                }
            }
        }
    }

    protected String remove() {
        if (isEmpty()) {
            return null;
        }
        String temp = items[index];
        items[index] = null;
        priority[index] = 0;
        index--;
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
}
