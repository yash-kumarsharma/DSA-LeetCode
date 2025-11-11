/*
LeetCode 230: Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Approach:
Perform inorder traversal (which gives sorted order for BST).
Return (k-1)-indexed element.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class KthSmallestElementBST {

    // Definition for a binary tree node.
    static class TreeNode {
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

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    // ---- Local Test Runner ----
    public static void main(String[] args) {
        KthSmallestElementBST sol = new KthSmallestElementBST();

        /*
              5
             / \
            3   6
           / \
          2   4
         /
        1
        */

        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6));

        System.out.println("k = 3 → " + sol.kthSmallest(root, 3)); // Expected: 3
        System.out.println("k = 5 → " + sol.kthSmallest(root, 5)); // Expected: 5
    }
}
