/**
 * LeetCode 643: Maximum Average Subarray I
 *
 * ✅ Approach (Sliding Window):
 * - Compute the sum of the first k elements.
 * - Store its average.
 * - Slide the window by:
 *      add current element
 *      subtract element leaving the window
 * - Update maximum average at each step.
 *
 * ✅ Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 *
 * ✅ Example:
 * nums = [1,12,-5,-6,50,3], k = 4
 * Output = 12.75
 */

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("Maximum Average: " + sol.findMaxAverage(nums, k));
        // Expected Output: 12.75
    }
}