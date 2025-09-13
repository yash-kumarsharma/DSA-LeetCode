/*
 LeetCode 3541: Find Most Frequent Vowel and Consonant
 https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
 Approach: Count frequencies of each letter, track max vowel & max consonant (O(n))
*/

class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConsonant = 0;

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            freq[index]++;

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowel = Math.max(maxVowel, freq[index]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[index]);
            }
        }

        return maxVowel + maxConsonant;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        FindMostFrequentVowelAndConsonant solution = new FindMostFrequentVowelAndConsonant();

        String s1 = "leetcode";
        printResult(solution.maxFreqSum(s1)); // Example Output: 5 (vowel 'e' freq=3 + consonant 't' freq=1)

        String s2 = "abababzzzz";
        printResult(solution.maxFreqSum(s2)); // Example Output: 7 (vowel 'a' freq=3 + consonant 'z' freq=4)
    }
}
