public class PQLLDriver {
    public static void main(String[] args) {
        PriorityQueueLinkedListMin pqh = new PriorityQueueLinkedListMin();
        pqh.insert("22", 22);
        pqh.insert("360", 360);
        pqh.insert("17", 17);
        pqh.insert("66", 66);
        pqh.print();
        System.out.println();
        System.out.println("Insert 43: ");
        pqh.insert("43", 43);
        pqh.print();
        System.out.println();
        System.out.println("Remove: ");
        pqh.remove();
        pqh.print();
        System.out.println();
        System.out.println("Change priority (360 -> 41): ");
        pqh.changePriority("360", 41);
        pqh.print();
        System.out.println();
        PriorityQueueLinkedListMax pq = new PriorityQueueLinkedListMax();
        pq.insert("22", 22);
        pq.insert("360", 360);
        pq.insert("17", 17);
        pq.insert("66", 66);
        pq.print();
        System.out.println();
        System.out.println("Insert 43: ");
        pq.insert("43", 43);
        pq.print();
        System.out.println();
        System.out.println("Remove: ");
        pq.remove();
        pq.print();
        System.out.println();
        System.out.println("Change priority (17 -> 41): ");
        pq.changePriority("17", 41);
        pq.print();
    }
}
