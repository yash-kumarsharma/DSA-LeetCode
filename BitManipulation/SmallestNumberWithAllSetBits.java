/*
 LeetCode 3370: Smallest Number With All Set Bits
 https://leetcode.com/problems/smallest-number-with-all-set-bits/
 Approach: Keep doubling num until (num - 1) >= n, return num - 1 (O(log n))
*/

class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int num = 2;
        while (num - 1 < n) {
            num *= 2;
        }
        return num - 1;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        SmallestNumberWithAllSetBits solution = new SmallestNumberWithAllSetBits();

        int result1 = solution.smallestNumber(5);
        printResult(result1); // Output: 7 (binary 111)

        int result2 = solution.smallestNumber(17);
        printResult(result2); // Output: 31 (binary 11111)
    }
}
