/*
 LeetCode 11: Container With Most Water
 https://leetcode.com/problems/container-with-most-water/
 Approach: Two Pointers (O(n))
*/

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);

            while (left < right && height[left] <= h) left++;
            while (left < right && height[right] <= h) right--;
        }

        return max;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        printResult(result); // Output: 49
    }
}
