/**
 * LeetCode 1768: Merge Strings Alternately
 *
 * ✅ Approach:
 * - Use two pointers for word1 and word2.
 * - Append characters alternately while either pointer is within bounds.
 * - If one string is longer, append remaining characters.
 *
 * ✅ Complexity:
 * - Time Complexity: O(n + m)
 * - Space Complexity: O(n + m)
 *
 * ✅ Example:
 * word1 = "abc"
 * word2 = "pqr"
 * Output = "apbqcr"
 */

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();

        int i1 = 0, i2 = 0;

        while (i1 < word1.length() || i2 < word2.length()) {

            if (i1 < word1.length()) {
                s.append(word1.charAt(i1));
                i1++;
            }

            if (i2 < word2.length()) {
                s.append(word2.charAt(i2)); // ✅ fixed index
                i2++;
            }
        }

        return s.toString();
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        MergeStringsAlternately sol = new MergeStringsAlternately();

        System.out.println(sol.mergeAlternately("abc", "pqr"));    // apbqcr
        System.out.println(sol.mergeAlternately("ab", "pqrs"));    // apbqrs
        System.out.println(sol.mergeAlternately("abcd", "pq"));    // apbqcd
    }
}