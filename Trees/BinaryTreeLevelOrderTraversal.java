/*
LeetCode 102: Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/

Approach:
Use a queue for Breadth-First Search (BFS).
For each level, process all nodes in the queue and enqueue their children.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.remove();
                level.add(current.val);

                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }

            list.add(level);
        }

        return list;
    }

    // --- For local testing ---
    public static void main(String[] args) {
        // Input: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);

        // Expected Output: [[3], [9, 20], [15, 7]]
        System.out.println(result);
    }
}
