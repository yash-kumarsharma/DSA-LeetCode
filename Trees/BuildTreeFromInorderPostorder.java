/*
LeetCode 106: Construct Binary Tree from Inorder and Postorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Approach:
- In postorder traversal, the last element is always the root.
- Use a HashMap to store the index of each value in the inorder array for O(1) lookup.
- Recursively build:
    - Right subtree first
    - Then left subtree
  because we are consuming postorder from the end.

Time Complexity: O(n)
Space Complexity: O(n) for HashMap + recursion stack
*/

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPostorder {

    private Map<Integer, Integer> indexMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Store inorder positions for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = indexMap.get(rootVal);

        // Build right subtree first (because postorder is reversed)
        root.right = build(inorder, postorder, inorderIndex + 1, inEnd);
        root.left = build(inorder, postorder, inStart, inorderIndex - 1);

        return root;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        BuildTreeFromInorderPostorder sol = new BuildTreeFromInorderPostorder();
        TreeNode root = sol.buildTree(inorder, postorder);

        // Expected Tree:
        //       3
        //     /   \
        //    9     20
        //         /  \
        //       15    7
    }
}
