package tree;

// LC 226 : Invert Binary Tree
// Invert a binary tree.
// Example 1:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]
// Example 2:
// Input: root = [2,1,3]
// Output: [2,3,1]


public class invertBT {
    public TreeNode invertTree(TreeNode root) { // time : O(n), space : O(n)
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
