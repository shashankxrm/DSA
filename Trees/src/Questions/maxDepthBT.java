package Questions;

// LC 104 : https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


public class maxDepthBT {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int ans = Math.max(left, right) + 1;

        return ans;
    }
}
