import java.util.*;

/**
 * LeetCode 1358: Number of Substrings Containing All Three Characters
 *
 * ✅ Approach:
 * - We track the **last seen index** of characters 'a', 'b', and 'c'.
 * - For every index i:
 *      update last seen position of current character.
 * - The earliest index among last seen positions determines
 *   how many valid substrings end at index i.
 *
 * - Formula:
 *      count += 1 + min(lastSeen[a], lastSeen[b], lastSeen[c])
 *
 * - Why?
 *   Because any substring starting from index 0 up to that minimum index
 *   will contain all three characters.
 *
 * ✅ Complexity:
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * Example:
 * Input: s = "abcabc"
 * Output: 10
 */

public class NumberOfSubstringsContainingABC {

    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            count += 1 + Math.min(lastSeen[0],
                     Math.min(lastSeen[1], lastSeen[2]));
        }

        return count;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        NumberOfSubstringsContainingABC sol =
                new NumberOfSubstringsContainingABC();

        System.out.println(sol.numberOfSubstrings("abcabc")); // Expected: 10
        System.out.println(sol.numberOfSubstrings("aaacb"));  // Expected: 3
        System.out.println(sol.numberOfSubstrings("abc"));    // Expected: 1
    }
}