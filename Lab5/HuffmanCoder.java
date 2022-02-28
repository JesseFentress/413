import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;

public class HuffmanCoder {
    
    public PriorityQueueHeapMin<Node> queue;

    public HuffmanCoder() {
        this.queue = new PriorityQueueHeapMin<Node>();
    }

    protected HashMap readFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String letters = br.readLine();
        HashMap<Character, Integer> frequencyMap = new HashMap();
        int index = 0;
        while (index < letters.length()) {
            char c = letters.charAt(index);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, (int)frequencyMap.get(c) + 1);
            }
            else {
                frequencyMap.put(c, 1);
            }
            index++;
        }
        return frequencyMap;
    }
    protected void toQueue(HashMap map) {
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry)itr.next();
            queue.insert(new Node(entry.getKey(), (int)entry.getValue()), (int)entry.getValue());
        }
    }

    protected Node toTree() {
        while (queue.size() != 1) {
            Node newNode = new Node();
            //newNode.left = new Node(queue.peek().data, queue.peekPriority());
            newNode.left = queue.peek();
            queue.remove();
            //newNode.right = new Node(queue.peek().data, queue.peekPriority());
            newNode.right = queue.peek();
            queue.remove();
            newNode.frequency = (Integer)newNode.right.frequency + (Integer)newNode.left.frequency;
            queue.insert(newNode, (Integer)newNode.frequency);
        }
        return queue.peek();
    }

    protected void printQueue() {
        for (int i = 1; i < queue.size() + 1; i++) {
            System.out.print(queue.heap[i][0] + " "+ queue.heap[i][1] + " ");   
            //System.out.println(queue.peekPriority());
        }
    }

    protected void t(Node node) {
        if (node != null) {
            System.out.println("[" + node.data + ", " + node.frequency + "]");
            t(node.left);
            t(node.right);
        }
    }
}

class Node<T> extends Object {
    
    T data;
    int frequency;
    Node left;
    Node right;

    protected Node() {
        this.data = null;
        this.frequency = 0;
        this.left = null;
        this.right = null;
    }

    protected Node(T data, T frequency) {
        this.data = data;
        this.frequency = (int)frequency;
        this.left = null;
        this.right = null;
    }

    protected void traverseNode(Node node) {
        if (node != null) {
            System.out.println("[" + this.data + ", " + this.frequency + "]");
            traverseNode(node.left);
            traverseNode(node.right);
        }
    }
}
