/*
 LeetCode 1480: Running Sum of 1d Array
 https://leetcode.com/problems/running-sum-of-1d-array/
 Approach: Prefix Sum (O(n))
*/

class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    // Utility method to print arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RunningSumOf1dArray solution = new RunningSumOf1dArray();
        int[] result = solution.runningSum(new int[]{1, 2, 3, 4});
        printArray(result); // Output: [1,3,6,10]
    }
}
