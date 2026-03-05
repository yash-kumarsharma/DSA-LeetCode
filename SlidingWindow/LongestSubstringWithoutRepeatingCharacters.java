import java.util.Arrays;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 *
 * ✅ Approach:
 * - Use Sliding Window technique.
 * - Maintain a hash array of size 256 to store the last index of each character.
 * - If a character repeats within the current window, move the left pointer
 *   just after the previous occurrence.
 * - Update the maximum length while expanding the window.
 *
 * Steps:
 * 1. Initialize a hash array with -1.
 * 2. Use two pointers (l and r) representing the window.
 * 3. If character already appeared and its index >= l, move l to index+1.
 * 4. Update max length.
 *
 * ✅ Complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (fixed size array of 256)
 *
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: "abc"
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        int n = s.length();

        while (r < n) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }

            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);

            hash[s.charAt(r)] = r;
            r++;
        }

        return maxLen;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol =
                new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Expected: 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
        System.out.println(sol.lengthOfLongestSubstring(""));         // Expected: 0
    }
}