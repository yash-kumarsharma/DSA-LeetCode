/*
LeetCode 101: Symmetric Tree
https://leetcode.com/problems/symmetric-tree/

Approach:
A tree is symmetric if the left subtree is a mirror of the right subtree.
To check this, recursively compare:
- Left child of left subtree with right child of right subtree
- Right child of left subtree with left child of right subtree

Time Complexity: O(n)
Space Complexity: O(h), where h is the height of the tree (recursion stack)
*/

public class SymmetricTree {

    public boolean mirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;

        return mirror(r1.left, r2.right) && mirror(r1.right, r2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }

    // --- Local Testing ---
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        SymmetricTree solution = new SymmetricTree();
        System.out.println(solution.isSymmetric(root)); // true
    }
}
