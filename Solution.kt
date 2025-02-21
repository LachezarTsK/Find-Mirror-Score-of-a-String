
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun calculateScore(input: String): Long {
        val indexesOfLettersOccurence = arrayOfNulls<ArrayDeque<Int>>(ALPHABET_SIZE)
        for (i in 0..<ALPHABET_SIZE) {
            indexesOfLettersOccurence[i] = ArrayDeque()
        }

        var mirrorScore: Long = 0
        for (i in input.indices) {
            val indexOfLetterInAlphabet = input[i] - 'a'
            val mirrorIndexOfLetterInAlphabet = ALPHABET_SIZE - indexOfLetterInAlphabet - 1

            if (indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet]!!.isEmpty()) {
                indexesOfLettersOccurence[indexOfLetterInAlphabet]!!.addLast(i)
                continue
            }
            mirrorScore += i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet]!!.removeLast()
        }

        return mirrorScore
    }
}
