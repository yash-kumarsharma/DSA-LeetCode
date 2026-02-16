/**
 * LeetCode 1343: Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * ✅ Approach (Sliding Window):
 * - Compute the sum of the first window of size k.
 * - If its average >= threshold, increment count.
 * - Slide the window by:
 *      add current element
 *      remove element leaving the window
 * - Check average for each window.
 *
 * ✅ Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 */

public class NumberOfSubarraysWithAvgAtLeastThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        if (currSum / k >= threshold) count++;

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            currSum = currSum + arr[i] - arr[i - k];
            if (currSum / k >= threshold) count++;
        }

        return count;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        NumberOfSubarraysWithAvgAtLeastThreshold sol =
                new NumberOfSubarraysWithAvgAtLeastThreshold();

        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println(sol.numOfSubarrays(arr, k, threshold)); // Expected: 3
    }
}