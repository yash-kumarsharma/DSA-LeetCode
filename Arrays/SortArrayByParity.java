/*
 LeetCode 905: Sort Array By Parity
 https://leetcode.com/problems/sort-array-by-parity/
 Approach: Two Pointers (O(n))
*/

class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();
        int[] result = solution.sortArrayByParity(new int[]{3,1,2,4});
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length-1 ? "," : ""));
        }
        System.out.println("]");
    }
}
