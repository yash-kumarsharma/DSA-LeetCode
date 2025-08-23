/*
 LeetCode 268: Missing Number
 https://leetcode.com/problems/missing-number/
 Approach: Math (Sum Formula) O(n)
*/

class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        return sum - sum1;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int result = solution.missingNumber(new int[]{3, 0, 1});
        printResult(result); // Output: 2
    }
}
