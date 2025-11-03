/*
LeetCode 235: Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Approach:
Use BST properties to recursively find the split point where one node lies
in the left subtree and the other in the right — that split point is the LCA.
If both p and q are smaller than root, move left; if both are larger, move right.

Time Complexity: O(h), where h is the height of the tree
Space Complexity: O(h) due to recursion stack
*/

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root; // split point or one of the nodes is the ancestor
    }

    // --- Local test ---
    public static void main(String[] args) {
        /*
               6
              / \
             2   8
            / \ / \
           0  4 7  9
             / \
            3   5

           p = 2, q = 8 → LCA = 6
           p = 2, q = 4 → LCA = 2
        */

        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9))
        );

        LowestCommonAncestorBST solution = new LowestCommonAncestorBST();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val); // 6
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val); // 2
    }
}
