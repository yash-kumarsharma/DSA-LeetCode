/*
LeetCode 404: Sum of Left Leaves
https://leetcode.com/problems/sum-of-left-leaves/

Approach:
- Traverse the binary tree.
- A left leaf is a node that:
    - is the left child of its parent, AND
    - has no children.
- Whenever we find such a node, add its value.
- Recursively compute for left and right subtrees.

Time Complexity: O(n)
Space Complexity: O(h) where h is tree height (recursive stack).
*/

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // Check if left child is a leaf
        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {

            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        SumOfLeftLeaves sol = new SumOfLeftLeaves();
        System.out.println(sol.sumOfLeftLeaves(root));
        // Expected Output: 24  (9 + 15)
    }
}
