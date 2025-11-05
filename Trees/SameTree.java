/*
LeetCode 100: Same Tree
https://leetcode.com/problems/same-tree/

Approach:
Recursively compare both trees.  
- If both are null → they match
- If one is null or values differ → not same
- Otherwise, compare left subtree and right subtree

Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree (recursion)
*/

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // --- Local Testing ---
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        SameTree solution = new SameTree();
        System.out.println(solution.isSameTree(p, q)); // true
    }
}
