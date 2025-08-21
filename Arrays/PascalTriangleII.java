/*
 LeetCode 119: Pascal's Triangle II
 https://leetcode.com/problems/pascals-triangle-ii/
 Approach: DP using 2D array (O(rowIndex^2))
*/

import java.util.ArrayList;
import java.util.List;

class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        }

        int[][] nums = new int[rowIndex + 1][];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[i + 1];
            nums[i][0] = nums[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
            }
        }

        int index = nums.length - 1;
        for (int i = 0; i < nums[index].length; i++) {
            list.add(nums[index][i]);
        }

        return list;
    }

    // Utility to print list
    private static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i < list.size() - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        PascalTriangleII solution = new PascalTriangleII();
        List<Integer> result = solution.getRow(4);
        printList(result); // Output: [1,4,6,4,1]
    }
}
