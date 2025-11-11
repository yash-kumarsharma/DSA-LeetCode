/*
LeetCode 70: Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

Approach:
- Classic Dynamic Programming: Each step can be reached from either (n-1)th or (n-2)th step.
- dp[i] = dp[i-1] + dp[i-2]

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(5)); // Output: 8
    }
}
