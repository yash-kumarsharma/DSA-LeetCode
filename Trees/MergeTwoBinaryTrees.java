/*
LeetCode 617: Merge Two Binary Trees
https://leetcode.com/problems/merge-two-binary-trees/

Approach:
- Recursively merge corresponding nodes.
- If one node is null, return the other.
- Otherwise, create a new node whose value is the sum of both nodes.

Time Complexity: O(n) where n is the total number of nodes.
Space Complexity: O(h) where h is tree height (recursion stack).
*/


public class MergeTwoBinaryTrees {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        MergeTwoBinaryTrees sol = new MergeTwoBinaryTrees();

        TreeNode root1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));

        TreeNode root2 = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));

        TreeNode merged = sol.mergeTrees(root1, root2);

        // Simple inorder print to verify structure
        printInorder(merged); // Expected output: 5 4 4 3 5 7
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
