/*
 LeetCode 3000: Maximum Area of Longest Diagonal Rectangle
 https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/
 Approach: Iterate and compare diagonal lengths (O(n))
*/

class AreaOfMaxDiagonal {
    public int areaOfMaxDiagonal(int[][] nums) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int i = 0; i < nums.length; i++) {
            int l = nums[i][0];
            int b = nums[i][1];
            int area = l * b;
            int diagonal = l * l + b * b; // squared diagonal length

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        AreaOfMaxDiagonal solution = new AreaOfMaxDiagonal();
        int[][] nums = {{9, 3}, {8, 6}};
        int result = solution.areaOfMaxDiagonal(nums);
        printResult(result); // Output: 48
    }
}
