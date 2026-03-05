/**
 * LeetCode 1004: Max Consecutive Ones III
 *
 * ✅ Approach:
 * - Use the Sliding Window technique.
 * - Maintain two pointers (l and r) representing the current window.
 * - Count the number of zeros in the window.
 * - If zeros exceed k, shrink the window from the left until zeros ≤ k.
 * - Track the maximum window length where at most k zeros are present.
 *
 * Steps:
 * 1. Expand the window using r.
 * 2. If nums[r] == 0, increment zero count.
 * 3. If zeros > k, move l forward and update zero count if needed.
 * 4. Update maximum length of valid window.
 *
 * ✅ Complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, zeros = 0;
        int n = nums.length;

        while (r < n) {
            if (nums[r] == 0) zeros++;

            if (zeros > k) {
                if (nums[l] == 0) zeros--;
                l++;
            }

            if (zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            r++;
        }

        return maxLen;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        MaxConsecutiveOnesIII sol = new MaxConsecutiveOnesIII();

        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(sol.longestOnes(nums1, 2)); // Expected: 6

        int[] nums2 = {0,0,1,1,1,0,0};
        System.out.println(sol.longestOnes(nums2, 0)); // Expected: 3
    }
}