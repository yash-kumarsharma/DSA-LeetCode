/*
 LeetCode 1446: Consecutive Characters
 https://leetcode.com/problems/consecutive-characters/
 Approach: Linear scan, count streaks (O(n))
*/

class ConsecutiveCharacters {
    public int maxPower(String s) {
        int count = 0, max = 0;
        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) max = count;
        }

        return max + 1; // +1 because count tracks additional length after first char
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        ConsecutiveCharacters solution = new ConsecutiveCharacters();
        String s = "abbcccddddeeeeedcba";
        int result = solution.maxPower(s);
        printResult(result); // Output: 5
    }
}
