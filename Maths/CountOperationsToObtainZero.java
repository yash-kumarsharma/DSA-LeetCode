/*
LeetCode 2169: Count Operations to Obtain Zero
https://leetcode.com/problems/count-operations-to-obtain-zero/

Approach:
- Repeatedly subtract the smaller number from the larger number until one becomes zero.
- Count how many operations are performed.

Time Complexity: O(max(num1, num2)) in worst case
Space Complexity: O(1)
*/

public class CountOperationsToObtainZero {

    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        CountOperationsToObtainZero sol = new CountOperationsToObtainZero();
        System.out.println(sol.countOperations(2, 3)); // Output: 3
    }
}
