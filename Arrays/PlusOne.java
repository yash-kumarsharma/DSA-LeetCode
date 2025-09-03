/*
 LeetCode 66: Plus One
 https://leetcode.com/problems/plus-one/
 Approach: Traverse from end, handle carry. O(n)
*/

class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
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
        PlusOne solution = new PlusOne();
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);
        printArray(result); // Output: [1,0,0,0]
    }
}
