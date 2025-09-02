/*
 LeetCode 27: Remove Element
 https://leetcode.com/problems/remove-element/
 Approach: Two Pointers (O(n))
*/

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
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
        RemoveElement solution = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int len = solution.removeElement(nums, 3);
        printArray(nums, len); // Output: [2,2]
    }
}
