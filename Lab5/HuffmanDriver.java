//import java.io.FileReader;
import java.io.IOException;
//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;

public class HuffmanDriver {
    public static void main(String[] args) throws IOException {
        File file = new File("letters.txt");
        HuffmanCoder hc = new HuffmanCoder();
        hc.toQueue(hc.readFile(file));
        hc.printQueue();
        hc.toTree();
        hc.printQueue();
        hc.t(hc.queue.peek());
        /*
        PriorityQueueHeapMin<Character> pqhm = new PriorityQueueHeapMin<Character>();
        PriorityQueueArray pqa = new PriorityQueueArray();
        HashMap hm = new HashMap();FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String letters = br.readLine();
        int index = 0;
        while (index < letters.length()) {
            char c = letters.charAt(index);
            if (hm.containsKey(c)) {
                hm.put(c, (int)hm.get(c) + 1);
            }
            else {
                hm.put(c, 1);
            }
            index++;
        }
        Iterator itr = hm.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry)itr.next();
            pqhm.minHeapInsert(entry.getKey(), (int)entry.getValue());
        }

        System.out.println(hm.keySet());
        System.out.println(hm.values());
        for (int i = 1; i < pqhm.size() + 1; i++) {
            System.out.print(pqhm.heap[i][0] + ""+ pqhm.heap[i][1] + " ");
        }*/
    }
}

