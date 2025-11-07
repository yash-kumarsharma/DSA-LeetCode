/*
LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Approach:
- In preorder traversal, the first element is always the root.
- Use a HashMap to store the index of each value in the inorder array for O(1) lookup.
- Recursively:
    - Build left subtree from left portion of inorder.
    - Build right subtree from right portion of inorder.

Time Complexity: O(n)
Space Complexity: O(n) for HashMap + recursion stack
*/

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPreorderInorder {

    private Map<Integer, Integer> indexMap;
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();

        // Store inorder positions for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = indexMap.get(rootVal);

        root.left = build(preorder, inStart, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, inEnd);

        return root;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildTreeFromPreorderInorder sol = new BuildTreeFromPreorderInorder();
        TreeNode root = sol.buildTree(preorder, inorder);

        // Expected Tree:
        //       3
        //     /   \
        //    9     20
        //         /  \
        //       15    7
    }
}
