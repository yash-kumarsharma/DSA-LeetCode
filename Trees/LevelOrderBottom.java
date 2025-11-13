/**
 * LeetCode 107: Binary Tree Level Order Traversal II
 *
 *  Approach:
 * - Perform a standard **level order traversal (BFS)** using a queue.
 * - For each level, collect all node values into a list.
 * - Append each level list to the main result list.
 * - Finally, reverse the list to get bottom-up order.
 *
 *  Algorithm Steps:
 * 1. Use a Queue to traverse the tree level by level.
 * 2. For every level, record all node values.
 * 3. Add children (left, right) to the queue.
 * 4. After BFS completes, reverse the list of levels.
 *
 *  Complexity:
 * - Time Complexity: O(N) — each node is visited once.
 * - Space Complexity: O(N) — due to the queue and result list.
 *
 *  Example:
 * Input Tree:
 *        3
 *       / \
 *      9  20
 *         / \
 *        15  7
 *
 * Output: [[15,7],[9,20],[3]]
 */

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.remove();
                level.add(current.val);

                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }

            list.add(level);
        }

        Collections.reverse(list);
        return list;
    }
}

public class LevelOrderBottom {
    public static void main(String[] args) {
        // Create test tree:
        //        3
        //       / \
        //      9  20
        //         / \
        //        15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        Solution sol = new Solution();
        List<List<Integer>> result = sol.levelOrderBottom(root);

        System.out.println("Bottom-Up Level Order Traversal:");
        System.out.println(result);
    }
}
