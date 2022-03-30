import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;

public class HuffmanCoder {

    public PriorityQueueHeapMin<Node> queue;
    public HashMap<Character, String> huffCodes;
    public Node tree;

    public HuffmanCoder() {
        this.queue = new PriorityQueueHeapMin<Node>();
        this.huffCodes = new HashMap<Character, String>();
    }

    protected HashMap readFile(File file) throws IOException {
        FileReader fr = new FileReader(file); 
        BufferedReader br = new BufferedReader(fr);
        String letters = br.readLine(); // String from file 
        HashMap<Character, Integer> frequencyMap = new HashMap();
        int index = 0;
        while (index < letters.length()) { // Iterate through entire string
            char c = letters.charAt(index);
            if (frequencyMap.containsKey(c)) { // Increment frequency value
                frequencyMap.put(c, (int) frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1); // Add character to hashmap
            }
            index++;
        }
        return frequencyMap;
    }

    protected void toQueue(HashMap map) {
        Iterator itr = map.entrySet().iterator(); // Hashmap iterator
        while (itr.hasNext()) { // Insert hashmap entires to the queue as nodes
            Map.Entry<Character, Integer> entry = (Map.Entry) itr.next();
            queue.insert(new Node(entry.getKey(), (int) entry.getValue()), (int) entry.getValue());
        }
    }

    protected Node toTree() {
        while (queue.size() != 1) { // Until there is only 1 item in the queue (1 tree)
            Node newNode = new Node(); // New node
            newNode.left = queue.peek(); // Add first item to left
            queue.remove();
            newNode.right = queue.peek(); // Add second item to right
            queue.remove();
            // New node's freq is the total of both child's frequency
            newNode.frequency = (Integer) newNode.right.frequency + (Integer) newNode.left.frequency;
            queue.insert(newNode, (Integer) newNode.frequency); // Reinsert node into the queue
        }
        tree = queue.peek(); // Remaining tree of all nodes
        return queue.peek();
    }

    protected void getCodes(Node<Character> node, String code) {
        if (node.isLeaf()) { // If we reach a leaf add to hashmap
            huffCodes.put((Character)node.data, code);
            return;
        }
        if (node.left != null) { // Traverse left
            getCodes(node.left, code + "0");
        }
        if (node.right != null) { // Traverse right
            getCodes(node.right, code + "1");
        }
    }

    protected void encodeFile(String read, String write) throws IOException {
        FileWriter fw = new FileWriter(new File(write));
        BufferedReader br = new BufferedReader(new FileReader(new File(read)));
        String letters = br.readLine(); // String from file
        int index = 0;
        while (index < letters.length()) { // Iterate through entire string
            char c = letters.charAt(index); // Current character
            if (huffCodes.containsKey(c)) { // If the character is in the hashmap
                try {
                    fw.write(huffCodes.get(c)); // Write the value from hashmap key of character
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            index++;
        }
        fw.close();
        br.close();
    }

    protected void decodeFile(String read, String write) throws IOException {
        FileWriter fw = new FileWriter(new File(write));
        BufferedReader br = new BufferedReader(new FileReader(new File(read)));
        String letters = br.readLine(); // String from file
        int index = 0;
        Node currNode = tree;
        while (index < letters.length()) { // Iterate through entire string
            if (currNode.isLeaf()) { // If reached a leaf node, decode
                fw.write((char)currNode.data);
                currNode = tree;
            }
            char c = letters.charAt(index); // Current character
            if (c == '0') { // If 0 traverse left
                currNode = currNode.left;
            }
            else { // If 1, then traverse right
                currNode = currNode.right;
            }
            index++;
        }
        fw.write((char)currNode.data); // Write the final character
        fw.close();
        br.close();
    }

    protected void printCodes() {
        Iterator itr = huffCodes.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Character, String> entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    protected void printQueue() {
        for (int i = 1; i < queue.size() + 1; i++) {
            System.out.print(queue.heap[i][0] + " " + queue.heap[i][1] + " ");
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
        this.frequency = (int) frequency;
        this.left = null;
        this.right = null;
    }

    protected boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }

    protected void traverseNode(Node node) {
        if (node != null) {
            System.out.println("[" + this.data + ", " + this.frequency + "]");
            traverseNode(node.left);
            traverseNode(node.right);
        }
    }
}
