/*
 LeetCode 169: Majority Element
 https://leetcode.com/problems/majority-element/
 Approach: Boyer–Moore Majority Vote Algorithm (O(n), O(1) space)
*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0, major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            if (num == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int result = solution.majorityElement(nums);
        printResult(result); // Output: 2
    }
}
