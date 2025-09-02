/*
 LeetCode 26: Remove Duplicates from Sorted Array
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 Approach: Two Pointers (O(n))
*/

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    // Utility to print array up to valid length
    private static void printArray(int[] arr, int len) {
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + (i < len - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = solution.removeDuplicates(nums);
        printArray(nums, len); // Output: [0,1,2,3,4]
    }
}
