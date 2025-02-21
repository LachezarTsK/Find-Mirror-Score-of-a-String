
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    public long CalculateScore(string input)
    {
        Stack<int>[] indexesOfLettersOccurence = new Stack<int>[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; ++i)
        {
            indexesOfLettersOccurence[i] = new Stack<int>();
        }

        long mirrorScore = 0;
        for (int i = 0; i < input.Length; ++i)
        {
            int indexOfLetterInAlphabet = input[i] - 'a';
            int mirrorIndexOfLetterInAlphabet = ALPHABET_SIZE - indexOfLetterInAlphabet - 1;

            if (indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].Count == 0)
            {
                indexesOfLettersOccurence[indexOfLetterInAlphabet].Push(i);
                continue;
            }
            mirrorScore += i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].Pop();
        }

        return mirrorScore;
    }
}
