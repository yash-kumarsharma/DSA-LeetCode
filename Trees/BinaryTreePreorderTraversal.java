/*
LeetCode 144: Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/

Approach:
Use recursion — visit the current node, then traverse the left subtree,
then the right subtree.

Time Complexity: O(n)
Space Complexity: O(n) due to recursion stack
*/

import java.util.*;

public class BinaryTreePreorderTraversal {

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: [1, null, 2, 3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        List<Integer> result = solution.preorderTraversal(root);

        // Expected Output: [1, 2, 3]
        System.out.println(result);
    }
}
