/*
 LeetCode 977: Squares of a Sorted Array
 https://leetcode.com/problems/squares-of-a-sorted-array/
 Approach: Two Pointers (O(n))
*/

class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[i--] = nums[left] * nums[left];
                left++;
            } else {
                arr[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();
        int[] result = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});

        System.out.print("[");
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + (j < result.length - 1 ? "," : ""));
        }
        System.out.println("]"); // Output: [0,1,9,16,100]
    }
}
