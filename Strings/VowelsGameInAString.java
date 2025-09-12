/*
 LeetCode 3227: Vowels Game in a String
 https://leetcode.com/problems/vowels-game-in-a-string/
 Approach: Alice wins if there's at least one vowel in the string (O(n))
*/

class VowelsGameInAString {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }

    // Utility to print result
    private static void printResult(boolean val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        VowelsGameInAString solution = new VowelsGameInAString();

        String s1 = "leetcode";
        printResult(solution.doesAliceWin(s1)); // Output: true

        String s2 = "rhythm";
        printResult(solution.doesAliceWin(s2)); // Output: false
    }
}
