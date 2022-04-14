public class PriorityQueueLinkedListMin {

    Node head;
    Node tail;
    int size;

    public PriorityQueueLinkedListMin() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    protected void insert(String item, int priority) {
        if (size() == 0) {
            head = new Node(item, priority);
            tail = head;
        }
        Node newNode = new Node(item, priority);
        Node currNode = head;
        Node prevNode = currNode;
        
    }

    protected int size() {
        return this.size;
    }

    public class Node() {

        String item;
        int priority;
        Node next;

        public Node(String item, int priority) {
            this.item = item;
            this.priority = priority;
            this.next = null;
        }


    }
}
