/*
LeetCode 112: Path Sum
https://leetcode.com/problems/path-sum/

Approach:
Use recursion to explore all root-to-leaf paths.
Subtract the current node’s value from the target sum at each step.
If a leaf node is reached and the remaining target equals the node value, return true.

Time Complexity: O(n)
Space Complexity: O(h), where h is the height of the tree
*/

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    // --- For local testing ---
    public static void main(String[] args) {
        /*
           Input:
               5
              / \
             4   8
            /   / \
           11  13  4
          /  \      \
         7    2      1

           targetSum = 22
           Expected Output: true
        */

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        PathSum solution = new PathSum();
        System.out.println(solution.hasPathSum(root, 22)); // true
    }
}
