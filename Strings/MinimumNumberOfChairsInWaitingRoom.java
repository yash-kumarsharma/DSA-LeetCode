/*
 LeetCode 3168: Minimum Number of Chairs in a Waiting Room
 https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/
 Approach: Simulate entry/exit and track peak occupancy (O(n))
*/

class MinimumNumberOfChairsInWaitingRoom {
    public int minimumChairs(String s) {
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                count++;
            } else {
                count--;
            }
            if (count > max) max = count;
        }
        return max;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        MinimumNumberOfChairsInWaitingRoom solution = new MinimumNumberOfChairsInWaitingRoom();
        String s = "ELEELEELLL";
        int result = solution.minimumChairs(s);
        printResult(result); // Example output: 3
    }
}
