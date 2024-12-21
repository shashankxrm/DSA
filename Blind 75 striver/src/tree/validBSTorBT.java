package tree;

// LC 98 : Validate Binary Search Tree
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
// A valid BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
// Input: root = [2,1,3]
// Output: true
// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
// Example 3:
// Input: root = [5,4,6,null,null,3,7]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

public class validBSTorBT {
    public boolean isValidBST(TreeNode root) { // time : O(n), space : O(n)
        return helper(root, null, null);
    }
    public boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if (low != null && node.val <= low) {
            return false;
        }

        if(high != null && node.val >= high) {
            return false;
        }

        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);

        return leftTree && rightTree;

    }
}