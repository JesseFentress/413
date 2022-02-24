public class PQDriver {
    public static void main(String[] args) {
       /* PriorityQueueLinkedList<String>  pqll = new PriorityQueueLinkedList<String>("ok");
        System.out.println(pqll.size());
        pqll.insert("penis", 123);
        System.out.println(pqll.peek());
        System.out.println(pqll.size());
        System.out.println("remove" + pqll.remove());
        pqll.insert("cock", 7);
        System.out.println(pqll.peek());
        System.out.println(pqll.size());
        pqll.insert("balls", 3004);
        System.out.println(pqll.peek());
        System.out.println(pqll.size());
        pqll.insert("anus", 4989);
        System.out.println(pqll.peek());
        pqll.changePriority("anus", 30);
        System.out.println(pqll.peek());
        System.out.println(pqll.size());
        System.out.println("remove" + pqll.remove());
        System.out.println("remove" + pqll.remove());
        System.out.println(pqll.peek());
        System.out.println(pqll.size());
        System.out.println("remove" + pqll.remove());
        System.out.println("remove" + pqll.remove());*/

        System.out.println("PQ with Array");
        PriorityQueueArray pqa = new PriorityQueueArray();
        pqa.insert("22", 22);
        pqa.insert("360", 360);
        pqa.insert("17", 17);
        pqa.insert("66", 66);
        pqa.print();
        System.out.println();
        System.out.println("Insert 45: ");
        pqa.insert("45", 45);
        pqa.print();
        System.out.println();
        System.out.println("Remove: ");
        pqa.remove();
        pqa.print();
        System.out.println();
        System.out.println("Change priority (17 -> 99): ");
        //pqa.changePriority();
        pqa.print();
        System.out.println();

        System.out.println("PQ with LL");
        PriorityQueueLinkedList<Integer> pqll = new PriorityQueueLinkedList<Integer>();
        pqll.insert(67, 67);
        pqll.insert(98, 98);
        pqll.insert(14, 14);
        pqll.insert(86, 86);
        pqll.print();
        System.out.println();
        System.out.println("Insert 395: ");
        pqll.insert(395, 395);
        pqll.print();
        System.out.println();
        System.out.println("Remove: ");
        pqll.remove();
        pqll.print();
        System.out.println();
        System.out.println("Change Priority (14 -> 91): ");
        pqll.changePriority(14, 91);
        pqll.print();
        System.out.println();

        System.out.println("PQ with Heap");
        PriorityQueueHeap<Integer> pqh = new PriorityQueueHeap<Integer>();
        pqh.insert(22, 22);
        pqh.insert(360, 360);
        pqh.insert(17, 17);
        pqh.insert(66, 66);
        pqh.print();
        System.out.println();
        System.out.println("Insert 86: ");
        pqh.insert(86, 86);
        pqh.print();
        System.out.println();
        System.out.println("Remove: ");
        pqh.remove();
        pqh.print();
        System.out.println();
        System.out.println("Change priority (66 -> 150): ");
        pqh.changePriority(66, 150);
        pqh.print();  

        System.out.println();
        System.out.println("Heap Sort Ascending: ");
        for (int i = 0; i < pqh.heap.length; i++) {
            if (pqh.heapsort()[i][0] != null) {
                System.out.print("[" + pqh.heapsort()[i][0] + " " +  pqh.heapsort()[i][1] + "]" + " ");
            }
        }
        
    }
}
