package tree;

// LC 124 : Binary Tree Maximum Path Sum
// Given a non-empty binary tree, find the maximum path sum.
// For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the
// parent-child connections.
// The path must contain at least one node and does not need to go through the root.
// Example 1:
// Input: root = [1,2,3]
// Output: 6
// Example 2:
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42


public class maxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) { // time : O(n), space : O(n)
        if(root == null) return 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
