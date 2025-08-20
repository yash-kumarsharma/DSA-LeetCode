/*
 LeetCode 48: Rotate Image
 https://leetcode.com/problems/rotate-image/
 Approach: 
 1. Transpose the matrix
 2. Reverse each row
*/

class RotateImage {
    // Helper method to reverse a row
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // Main rotation method
    public void rotate(int[][] matrix) {
        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    // Utility to print 2D matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + (j < matrix[i].length - 1 ? "," : ""));
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        solution.rotate(matrix);
        printMatrix(matrix); 
        // Output:
        // [7,4,1]
        // [8,5,2]
        // [9,6,3]
    }
}
