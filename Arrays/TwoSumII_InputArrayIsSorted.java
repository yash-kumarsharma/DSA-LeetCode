/*
 LeetCode 167: Two Sum II - Input Array Is Sorted
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 Approach: Two Pointers (O(n))
*/

class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] arr = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                arr[0] = left + 1;  // 1-indexed
                arr[1] = right + 1;
                return arr;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return arr;
    }

    // Utility to print array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        TwoSumII_InputArrayIsSorted solution = new TwoSumII_InputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        printArray(result); // Output: [1,2]
    }
}
