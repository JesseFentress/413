public class PQDriver {
    public static void main(String[] args) {
        PriorityQueueLinkedList<String>  pqll = new PriorityQueueLinkedList<String>("ok");
        PriorityQueueArray pqa = new PriorityQueueArray();

       /* pqll.insert("15", 15);
        pqll.insert("19", 15);
        pqll.insert("348", 15);
        pqll.insert("8", 15);
        pqll.insert("26", 15);*/

        /*pqa.insert("15", 15);
        pqa.insert("19", 19);
        pqa.insert("348", 348);
        pqa.insert("8", 8);
        pqa.insert("26", 26);*/

        for (int i = pqa.size(); i > 0; i --) {
            System.out.print(pqa.items[i] + " ");
        }
        System.out.println();
        System.out.println("Insert 150: ");
        //pqa.insert("150", 150);
        for (int i = pqa.size(); i > 0; i --) {
            System.out.print(pqa.items[i] + " ");
        }
        System.out.println();
        System.out.println("Remove: ");
        pqa.remove();
        for (int i = pqa.size(); i > 0; i --) {
            System.out.print(pqa.items[i] + " ");
        }
        

        /*PriorityQueueArray pqa = new PriorityQueueArray("max");
        System.out.println(pqa.size());
        System.out.println(pqa.peek());
        pqa.insert("ok", 30);
        System.out.println(pqa.peek());
        pqa.insert("im", 1);
        System.out.println(pqa.peek());
        pqa.insert("not", 12);
        System.out.println(pqa.peek());
        pqa.insert("sure", 45);
        System.out.println(pqa.remove());
        System.out.println(pqa.remove());
        System.out.println(pqa.peek());
        System.out.println(pqa.size());*/
    }
}
