/*
 LeetCode 125: Valid Palindrome
 https://leetcode.com/problems/valid-palindrome/
 Approach: Two Pointers, skip non-alphanumeric chars (O(n))
*/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    // Utility to print result
    private static void printResult(boolean val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        String s1 = "A man, a plan, a canal: Panama";
        printResult(solution.isPalindrome(s1)); // Output: true

        String s2 = "race a car";
        printResult(solution.isPalindrome(s2)); // Output: false
    }
}
