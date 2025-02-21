
/**
 * @param {string} input
 * @return {number}
 */
var calculateScore = function (input) {
    const ALPHABET_SIZE = 26;
    const ASCII_SMALL_SIZE_A = 97;
    const indexesOfLettersOccurence = Array.from(new Array(ALPHABET_SIZE), () => new Array());

    let mirrorScore = 0;
    for (let i = 0; i < input.length; ++i) {
        const indexOfLetterInAlphabet = input.codePointAt(i) - ASCII_SMALL_SIZE_A;
        const mirrorIndexOfLetterInAlphabet = ALPHABET_SIZE - indexOfLetterInAlphabet - 1;

        if (indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].length === 0) {
            indexesOfLettersOccurence[indexOfLetterInAlphabet].push(i);
            continue;
        }
        mirrorScore += i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].pop();
    }

    return mirrorScore;
};
