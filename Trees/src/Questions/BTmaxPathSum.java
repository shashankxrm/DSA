package Questions;

// LC 124 : https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Given a non-empty binary tree, find the maximum path sum.
// For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the root.


public class BTmaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
