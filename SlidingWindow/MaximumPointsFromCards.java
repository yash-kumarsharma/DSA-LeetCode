/**
 * LeetCode 1423: Maximum Points You Can Obtain from Cards
 *
 * ✅ Approach:
 * - You can take exactly k cards from either the beginning or the end.
 * - First, take all k cards from the left and compute sum.
 * - Then gradually:
 *      remove one card from the left
 *      add one card from the right
 * - Track the maximum sum during this process.
 *
 * ✅ Complexity:
 * - Time Complexity: O(k)
 * - Space Complexity: O(1)
 *
 * ✅ Example:
 * cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output = 12
 */

public class MaximumPointsFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;

        // Take first k cards from left
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;

        // Slide: remove from left, add from right
        for (int l = k - 1, r = cardPoints.length - 1; l >= 0; l--, r--) {
            leftSum -= cardPoints[l];
            rightSum += cardPoints[r];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        MaximumPointsFromCards sol = new MaximumPointsFromCards();

        int[] cards1 = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(sol.maxScore(cards1, 3)); // Expected: 12

        int[] cards2 = {2, 2, 2};
        System.out.println(sol.maxScore(cards2, 2)); // Expected: 4

        int[] cards3 = {9, 7, 7, 9, 7, 7, 9};
        System.out.println(sol.maxScore(cards3, 7)); // Expected: 55
    }
}