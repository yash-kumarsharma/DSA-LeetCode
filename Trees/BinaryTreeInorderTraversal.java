/*
LeetCode 94: Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/

Approach:
Recursive inorder traversal — visit left subtree, then node, then right subtree.

Time Complexity: O(n)
Space Complexity: O(n) (recursion stack)
*/

import java.util.*;

public class BinaryTreeInorderTraversal {

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: [1, null, 2, 3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> result = solution.inorderTraversal(root);

        // Expected Output: [1, 3, 2]
        System.out.println(result);
    }
}
