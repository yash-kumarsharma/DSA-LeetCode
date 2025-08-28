/*
 LeetCode 215: Kth Largest Element in an Array
 https://leetcode.com/problems/kth-largest-element-in-an-array/
 Approach: Sort the array (O(n log n))
*/

import java.util.Arrays;

class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        KthLargestElementInArray solution = new KthLargestElementInArray();
        int result = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        printResult(result); // Output: 5
    }
}
