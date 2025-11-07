/*
LeetCode 222: Count Complete Tree Nodes
https://leetcode.com/problems/count-complete-tree-nodes/

Approach:
Use simple recursion:
- Count nodes in left subtree.
- Count nodes in right subtree.
- Return left + right + 1 (for the current node).

Time Complexity: O(n)
Space Complexity: O(h) where h is tree height (recursive stack).
*/

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null)
        );

        CountCompleteTreeNodes sol = new CountCompleteTreeNodes();
        System.out.println(sol.countNodes(root)); 
        // Expected Output: 6
    }
}
