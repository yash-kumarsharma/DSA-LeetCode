/*
 LeetCode 136: Single Number
 https://leetcode.com/problems/single-number/
 Approach: XOR (O(n), O(1) space)
*/

class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        printResult(result); // Output: 4
    }
}
