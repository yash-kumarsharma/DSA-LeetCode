/*
 LeetCode 3516: Find the Closest Palindrome to Target (variant: closest number)
 https://leetcode.com/problems/find-closest-number-to-target/
 Approach: Compare absolute differences (O(1))
*/

class FindClosestNumberToTarget {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(z - x);
        int b = Math.abs(z - y);

        if (a == b) {
            return 0; // both equally close
        } else if (a < b) {
            return 1; // x is closer
        }
        return 2; // y is closer
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        FindClosestNumberToTarget solution = new FindClosestNumberToTarget();
        int result1 = solution.findClosest(3, 8, 6);
        printResult(result1); // Output: 2 (8 is closer to 6)

        int result2 = solution.findClosest(4, 10, 7);
        printResult(result2); // Output: 0 (both 4 and 10 equally close to 7)
    }
}
