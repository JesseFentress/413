import java.util.LinkedList;


public class PriorityQueueLinkedList<T> {
    LinkedList<T> list = new LinkedList<T>();
    String m;

    public PriorityQueueLinkedList(String m) {
        this.m = m;
    }

    protected void insert(T item, int priority) {
        //list.add(item, priority);
    }

    protected T peek() {
        return list.getFirst();
    }

    protected T remove() {
        return list.removeFirst();
    }

    protected void changePriority(T item , int priority) {
        
    }

    protected boolean isEmpty() {
        return list.isEmpty();
    }

    protected int size() {
        return list.size();
    } 
}