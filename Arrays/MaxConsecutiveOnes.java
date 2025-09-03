/*
 LeetCode 485: Max Consecutive Ones
 https://leetcode.com/problems/max-consecutive-ones/
 Approach: One Pass, count streaks of 1s (O(n))
*/

class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) max = count;
        }
        return max;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        int result = solution.findMaxConsecutiveOnes(nums);
        printResult(result); // Output: 3
    }
}
