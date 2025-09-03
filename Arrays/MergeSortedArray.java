/*
 LeetCode 88: Merge Sorted Array
 https://leetcode.com/problems/merge-sorted-array/
 Approach: Merge with extra array (O(m+n))
*/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int idx1 = 0, idx2 = 0, x = 0;

        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] <= nums2[idx2]) {
                merged[x++] = nums1[idx1++];
            } else {
                merged[x++] = nums2[idx2++];
            }
        }

        while (idx1 < m) {
            merged[x++] = nums1[idx1++];
        }

        while (idx2 < n) {
            merged[x++] = nums2[idx2++];
        }

        for (int i = 0; i < merged.length; i++) {
            nums1[i] = merged[i];
        }
    }

    // Utility to print array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        printArray(nums1); // Output: [1,2,2,3,5,6]
    }
}
