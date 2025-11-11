/*
LeetCode 98: Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/

Approach:
Use DFS with min/max bounds.
For each node:
- node.val must be strictly between (min, max)
- update bounds when moving left and right.

Time Complexity: O(n)
Space Complexity: O(h), h = height of tree (recursion stack)
*/

public class ValidateBinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
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

    public boolean valid(TreeNode root, long max, long min) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return valid(root.left, root.val, min) &&
               valid(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();

        // Example BST (Valid)
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));

        // Example invalid BST
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        System.out.println("Tree 1 is BST: " + sol.isValidBST(root1)); // true
        System.out.println("Tree 2 is BST: " + sol.isValidBST(root2)); // false
    }
}
