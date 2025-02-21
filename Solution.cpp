
#include <array>
#include <string>
#include <vector>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;

public:
    long long calculateScore(const string& input) const {
        /*
        Alternative to array<vector<int>, ALPHABET_SIZE>:
        array<deque<int>, ALPHABET_SIZE>
        array<stack<int>, ALPHABET_SIZE>
        array<list<int>, ALPHABET_SIZE>

        Since we are only adding / removing from the back, vector is as good as,
        or even better than, the alternatives.

        The implementation of vector always uses a continuous chunk of memory,
        which makes it extremely fast for most operations.
        So, unless there are some specific requirements,
        such as removing an element from the middle or the front,
        vector should be your resizable container of choice in C++.
        */
        array<vector<int>, ALPHABET_SIZE>indexesOfLettersOccurence{};

        long long mirrorScore = 0;
        for (int i = 0; i < input.length(); ++i) {
            int indexOfLetterInAlphabet = input[i] - 'a';
            int mirrorIndexOfLetterInAlphabet = ALPHABET_SIZE - indexOfLetterInAlphabet - 1;

            if (indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].empty()) {
                indexesOfLettersOccurence[indexOfLetterInAlphabet].push_back(i);
                continue;
            }
            mirrorScore += i - indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].back();
            indexesOfLettersOccurence[mirrorIndexOfLetterInAlphabet].pop_back();
        }

        return mirrorScore;
    }
};
