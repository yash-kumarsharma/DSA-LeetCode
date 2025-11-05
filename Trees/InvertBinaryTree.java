/*
LeetCode 226: Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/

Approach:
Swap the left and right children of every node recursively.

Time Complexity: O(n)
Space Complexity: O(h) where h = height of tree (recursion stack)
*/

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode inverted = solution.invertTree(root);

        // Expected Output Tree (mirrored of original)
        //       4
        //     /   \
        //    7     2
        //   / \   / \
        //  9   6 3   1
    }
}
