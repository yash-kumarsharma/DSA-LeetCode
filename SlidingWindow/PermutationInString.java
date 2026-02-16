/**
 * LeetCode 567: Permutation in String
 *
 * ✅ Approach (Sliding Window + Frequency Arrays):
 * - If s1 is longer than s2, return false.
 * - Maintain two frequency arrays of size 26:
 *      a1 → frequency of characters in s1
 *      a2 → frequency of current window in s2
 * - Initialize both arrays for the first window.
 * - Slide the window one character at a time:
 *      add new character
 *      remove outgoing character
 * - If both frequency arrays match at any point, return true.
 *
 * ✅ Complexity:
 * - Time Complexity: O(N * 26) ≈ O(N)
 * - Space Complexity: O(26) ≈ O(1)
 */

public class PermutationInString {

    public boolean equal(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        int window = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        if (equal(a1, a2)) return true;

        for (int i = window; i < s2.length(); i++) {
            a2[s2.charAt(i) - 'a']++;
            a2[s2.charAt(i - window) - 'a']--;

            if (equal(a1, a2)) return true;
        }

        return false;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        PermutationInString sol = new PermutationInString();

        System.out.println(sol.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(sol.checkInclusion("ab", "eidboaoo")); // false
    }
}