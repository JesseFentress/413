public class PriorityQueueLinkedList<T> {
    public class Node {
        T value;
        int priority;
        Node next;
    
        public Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public PriorityQueueLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    protected void insert(T item, int priority) {
        if (size() == 0) {
            head = new Node(item, priority);
            tail = head;
            size++;
            return;
        }
        Node newNode = new Node(item, priority);
        Node currNode = head;
        Node prevNode = currNode;
        while (currNode != null && currNode.priority > newNode.priority) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode == head) {
            newNode.next = currNode;
            head = newNode;
        }
        else if (currNode == null) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = currNode;
            prevNode.next = newNode;
        }
        size++;
    }

    protected T peek() {
        return head.value;
    }

    protected T remove() {
        if (size() == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.value;
    }

    protected void changePriority(T item , int priority) {
        Node currNode = head;
        Node prevNode = currNode;

        while (currNode != null && currNode.value != item) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode == head) {
            remove();
            insert(item, priority);
            
        }
        else if (currNode == null) {
            return;
        }
        else {
            prevNode.next = currNode.next;
            insert(item, priority);
        }
    }

    protected boolean isEmpty() {
        return size() == 0;
    }

    protected int size() {
        return this.size;
    } 

    protected void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.value + " " + temp.priority + "]" + " ");
            temp = temp.next;
        }
    }
 }