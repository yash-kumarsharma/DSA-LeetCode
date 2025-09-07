/*
 LeetCode 1304: Find N Unique Integers Sum up to Zero
 https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 Approach: Pair numbers i and -i, add 0 if n is odd (O(n))
*/

class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int index = 0;

        for (int i = 1; i <= n / 2; i++) {
            arr[index++] = i;
            arr[index++] = -i;
        }

        if (n % 2 != 0) arr[index] = 0;

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
        FindNUniqueIntegersSumUpToZero solution = new FindNUniqueIntegersSumUpToZero();
        int[] result = solution.sumZero(5);
        printArray(result); // Example Output: [1,-1,2,-2,0]
    }
}
