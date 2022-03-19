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
        hc.getCodes(hc.toTree(), "");
        hc.printCodes();
        hc.encodeFile("letters.txt", "encode.txt");
        hc.decodeFile("encode.txt", "decode.txt");
    }
}

