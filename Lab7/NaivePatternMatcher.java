import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class NaivePatternMatcher implements PatternMatcherInterface {
    
    @Override
    public List<Integer> patternMatch(String text, String pattern) {
        CharacterIterator textIterator = new StringCharacterIterator(text);
        CharacterIterator textStartIterator = new StringCharacterIterator(text);
        CharacterIterator patternIterator = new StringCharacterIterator(pattern);
        List<Integer> patternOccurences = new ArrayList<>();
        int patternIndex = 0;
        
        while (textIterator.current() != CharacterIterator.DONE) {
            if (textIterator.current() == patternIterator.current()) {
                if (patternIterator.getIndex() == 0) { patternIndex = textIterator.getIndex(); }
                textIterator.next();
                patternIterator.next();
                if (patternIterator.current() == CharacterIterator.DONE) {
                    patternOccurences.add(patternIndex);
                    patternIterator = new StringCharacterIterator(pattern);
                }
            }
            else {
                patternIterator = new StringCharacterIterator(pattern);
                if (textIterator.current() == patternIterator.current()) {
                    patternIterator.next();
                }
                textStartIterator.next();
                textIterator = textStartIterator;
            }
        }
        if (patternOccurences.size() == 0) { patternOccurences.add(-1); }
        return patternOccurences;
    }

}
