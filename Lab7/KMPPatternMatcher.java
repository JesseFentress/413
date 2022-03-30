import java.util.ArrayList;
import java.util.List;

public class KMPPatternMatcher implements PatternMatcherInterface {

    @Override
    public List<Integer> patternMatch(String text, String pattern) {
        if (pattern.equals("")) { 
            List<Integer> badInput = new ArrayList<Integer>();
            badInput.add(-1);
            return badInput;
        }
        int textPointer = 0,  patternPointer = 0;
        int[] LPSArray = getLPS(pattern);
        List<Integer> patternOccurences = new ArrayList<>();
        while (textPointer < text.length()) {
            while (patternPointer > 0 && pattern.charAt(patternPointer) != text.charAt(textPointer)) {
                patternPointer = LPSArray[patternPointer - 1];
            }
            if (pattern.charAt(patternPointer) == text.charAt(textPointer)) {
                if (patternPointer == pattern.length() - 1) {
                    patternOccurences.add(textPointer - patternPointer);
                    patternPointer = LPSArray[patternPointer];
                }
                else {
                    patternPointer++;
                }
            }
            textPointer++;
        }
        if (patternOccurences.size() == 0) { patternOccurences.add(-1); }
        return patternOccurences;
    }
    
    private int[] getLPS(String text) {
        int[] LPSArray = new int[text.length()];
        int topPointer = 0;
        for (int bottomPointer = 1; bottomPointer < text.length(); bottomPointer++) {
            while (topPointer > 0 && text.charAt(bottomPointer) != text.charAt(topPointer)) {
                topPointer = LPSArray[topPointer - 1];
            }
            if (text.charAt(topPointer) == text.charAt(bottomPointer)) {
                topPointer++;
                LPSArray[bottomPointer] = topPointer;
            }
        }

        return LPSArray;
    }
    
}
