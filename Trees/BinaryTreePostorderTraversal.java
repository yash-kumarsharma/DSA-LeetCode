/*
LeetCode 145: Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/

Approach:
Recursive postorder traversal — visit left subtree, then right subtree, then the node.

Time Complexity: O(n)
Space Complexity: O(n) due to recursion stack
*/

import java.util.*;

public class BinaryTreePostorderTraversal {

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: [1, null, 2, 3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();
        List<Integer> result = solution.postorderTraversal(root);

        // Expected Output: [3, 2, 1]
        System.out.println(result);
    }
}
