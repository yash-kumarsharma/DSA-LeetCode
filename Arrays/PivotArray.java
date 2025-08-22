/*
 LeetCode 2161: Partition Array According to Given Pivot
 https://leetcode.com/problems/partition-array-according-to-given-pivot/
 Approach: 3-pass iteration (O(n))
*/

class PivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                arr[index++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                arr[index++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                arr[index++] = num;
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
        PivotArray solution = new PivotArray();
        int[] result = solution.pivotArray(new int[]{9,12,5,10,14,3,10}, 10);
        printArray(result); // Output: [9,5,3,10,10,12,14]
    }
}
