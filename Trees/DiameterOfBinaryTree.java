import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int diameter;

    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        // Create test tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        int result = sol.diameterOfBinaryTree(root);

        System.out.println("Diameter of Binary Tree: " + result);
    }
}
