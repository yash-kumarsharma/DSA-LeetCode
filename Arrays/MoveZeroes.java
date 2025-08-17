/*
 LeetCode 283: Move Zeroes
 https://leetcode.com/problems/move-zeroes/
 Approach: Two Pointers (O(n))
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + (i < nums.length - 1 ? "," : ""));
        }
        System.out.println("]"); // Output: [1,3,12,0,0]
    }
}
