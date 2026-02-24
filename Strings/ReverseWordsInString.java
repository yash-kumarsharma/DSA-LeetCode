/**
 * LeetCode 151: Reverse Words in a String
 *
 * ✅ Approach:
 * - Trim leading and trailing spaces.
 * - Split the string using regex "\\s+" to handle multiple spaces.
 * - Traverse the words array in reverse order.
 * - Append each word to a StringBuilder with a single space.
 * - Trim final result to remove extra trailing space.
 *
 * ✅ Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(N)
 *
 * ✅ Example:
 * Input:  "  the sky   is blue  "
 * Output: "blue is sky the"
 */

public class ReverseWordsInString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");

        StringBuilder st = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            st.append(words[i]);
            st.append(" ");
        }

        return st.toString().trim();
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        ReverseWordsInString sol = new ReverseWordsInString();

        System.out.println(sol.reverseWords("the sky is blue"));
        // Output: "blue is sky the"

        System.out.println(sol.reverseWords("  hello world  "));
        // Output: "world hello"

        System.out.println(sol.reverseWords("a good   example"));
        // Output: "example good a"
    }
}