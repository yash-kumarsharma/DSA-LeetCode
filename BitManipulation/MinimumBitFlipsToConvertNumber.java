/*
 LeetCode 2220: Minimum Bit Flips to Convert Number
 https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 Approach: XOR to find differing bits, then count set bits (O(1))
*/

class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        return Integer.bitCount(num);
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        MinimumBitFlipsToConvertNumber solution = new MinimumBitFlipsToConvertNumber();

        int result1 = solution.minBitFlips(10, 7);
        printResult(result1); // Output: 3 (binary 1010 → 0111)

        int result2 = solution.minBitFlips(3, 4);
        printResult(result2); // Output: 3 (011 → 100)
    }
}
