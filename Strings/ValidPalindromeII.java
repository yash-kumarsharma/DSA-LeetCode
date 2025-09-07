/*
 LeetCode 680: Valid Palindrome II
 https://leetcode.com/problems/valid-palindrome-ii/
 Approach: Two Pointers + at most one deletion (O(n))
*/

class ValidPalindromeII {
    private boolean palindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return palindrome(s, l, r - 1) || palindrome(s, l + 1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    // Utility to print result
    private static void printResult(boolean val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        ValidPalindromeII solution = new ValidPalindromeII();

        String s1 = "aba";
        printResult(solution.validPalindrome(s1)); // Output: true

        String s2 = "abca";
        printResult(solution.validPalindrome(s2)); // Output: true

        String s3 = "abc";
        printResult(solution.validPalindrome(s3)); // Output: false
    }
}
