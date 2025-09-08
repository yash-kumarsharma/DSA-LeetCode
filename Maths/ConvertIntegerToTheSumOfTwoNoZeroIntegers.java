/*
 LeetCode 1317: Convert Integer to the Sum of Two No-Zero Integers
 https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 Approach: Brute force check, ensure no digit is zero (O(n * log n))
*/

class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    private boolean check(int x) {
        while (x > 0) {
            if (x % 10 == 0) return false;
            x /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (check(i) && check(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[0];
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
        ConvertIntegerToTheSumOfTwoNoZeroIntegers solution = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();

        int[] result1 = solution.getNoZeroIntegers(11);
        printArray(result1); // Example Output: [2,9]

        int[] result2 = solution.getNoZeroIntegers(1010);
        printArray(result2); // Example Output: [11,999]
    }
}
