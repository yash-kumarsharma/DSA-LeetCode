/*
LeetCode 111: Minimum Depth of Binary Tree
https://leetcode.com/problems/minimum-depth-of-binary-tree/

Approach:
Use recursion.  
If one child is null, we must take depth of the other child.  
Otherwise, take the minimum of both subtrees.

Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree (recursion depth).
*/

public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        MinDepthBinaryTree sol = new MinDepthBinaryTree();
        System.out.println(sol.minDepth(root)); 
        // Expected Output: 2 (path: 3 → 9)
    }
}
