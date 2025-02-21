
package main

const ALPHABET_SIZE = 26

func calculateScore(input string) int64 {
    indexesOfLettersOccurence := make([][]int, ALPHABET_SIZE)

    var mirrorScore int64 = 0
    for i := range input {
        indexOfLetterInAlphabet := input[i] - 'a'
        mirrorIndexOfLetterInAlphabet := ALPHABET_SIZE - indexOfLetterInAlphabet - 1

        if len(indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet]) == 0 {
            indexesOfLettersOccurence[indexOfLetterInAlphabet] = append(indexesOfLettersOccurence[indexOfLetterInAlphabet], i)
            continue
        }
        lastIndex := len(indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet]) - 1
        mirrorScore += int64(i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet][lastIndex])
        indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet] = indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet][0 : lastIndex]
    }

    return mirrorScore
}
