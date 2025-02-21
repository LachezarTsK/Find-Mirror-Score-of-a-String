
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public long calculateScore(String input) {
        Deque<Integer>[] indexesOfLettersOccurence = new ArrayDeque[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            indexesOfLettersOccurence[i] = new ArrayDeque<>();
        }

        long mirrorScore = 0;
        for (int i = 0; i < input.length(); ++i) {
            int indexOfLetterInAlphabet = input.charAt(i) - 'a';
            int mirrorIndexOfLetterInAlphabet = ALPHABET_SIZE - indexOfLetterInAlphabet - 1;

            if (indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].isEmpty()) {
                indexesOfLettersOccurence[indexOfLetterInAlphabet].addFirst(i);
                continue;
            }
            mirrorScore += i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].pollFirst();
        }

        return mirrorScore;
    }
}
