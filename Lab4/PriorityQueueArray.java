import java.util.Arrays;

public class PriorityQueueArray {

    private String[] items;
    private int[] priority;
    private int index = -1;

    public PriorityQueueArray() {
        this.items = new String[10];
        this.priority = new int[10];
    }

    protected int peek() {
        if (isEmpty()) {
            return -1;
        }
        return priority[index];
    }

    protected void insert(String newItem, int newItemPriority) {
       if (isFull()) {
            String[] temp = Arrays.copyOf(items, size() * 2);
            items = temp;
        }
        if (index == -1) {  
            index++;
            items[index] = newItem;
            priority[index] = newItemPriority;
            return;
        }
        else {
            index++;
            for (int i = index - 1; i >= 0; i--) {
                if (priority[i] >= newItemPriority) {
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

    protected void changePriority(String item, String newPriority) {

    }

    protected boolean isFull() {
        return index == priority.length;
    }

    protected boolean isEmpty() {
        return size() == 0;
    }

    protected int size() {
        return index + 1;
    }   

    protected void print() {
        for (int i = size(); i > 0; i--) {
            System.out.print("[" + items[i] + " " + priority[i] + "]" + " ");
        }
    }
}
