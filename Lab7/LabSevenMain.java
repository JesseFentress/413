import java.util.List;

public class LabSevenMain {
    public static void main(String[] args) {
        printNPM("This is a CMPSC 412 lab course. Students take this course along with CMPSC 462", "CMPSC");
        System.out.println();
        System.out.println();
        printNPM("This is a CMPSC 412 lab course. Students take this course along with CMPSC 462", "course");
        System.out.println();
        System.out.println();
        printNPM("AABAACAADAABAABAABBBBBAAABDCBA", "BBBBBA");
        System.out.println();
        System.out.println();
        printKMP("This is a CMPSC 412 lab course. Students take this course along with CMPSC 462", "CMPSC");
        System.out.println();
        System.out.println();
        printKMP("This is a CMPSC 412 lab course. Students take this course along with CMPSC 462", "course");
        System.out.println();
        System.out.println();
        printKMP("AABAACAADAABAABAABBBBBAAABDCBA", "BBBBBA");
    }

    public static void printNPM(String text, String pattern) {
        NaivePatternMatcher npm = new NaivePatternMatcher();
        List<Integer> results = npm.patternMatch(text, pattern);
        System.out.println("Input Text: " + text);
        System.out.println("Input Pattern: " + pattern);
        if (results.size() == 1 && results.get(0) == -1) {
            System.out.println("Pattern was not found within the text.");
            return;
        }
        System.out.print("Pattern was found at index ");
        for (int index = 0; index < results.size(); index++) {
            System.out.print(results.get(index));
            if (index < results.size() - 1) {
                System.out.print(" and index ");
            }
        }
    }

    public static void printKMP(String text, String pattern) {
        KMPPatternMatcher kmp = new KMPPatternMatcher();
        List<Integer> results = kmp.patternMatch(text, pattern);
        System.out.println("Input Text: " + text);
        System.out.println("Input Pattern: " + pattern);
        if (results.size() == 1 && results.get(0) == -1) {
            System.out.println("Pattern was not found within the text.");
            return;
        }
        System.out.print("Pattern was found at index ");
        for (int index = 0; index < results.size(); index++) {
            System.out.print(results.get(index));
            if (index < results.size() - 1) {
                System.out.print(" and index ");
            }
        }
    }
}
