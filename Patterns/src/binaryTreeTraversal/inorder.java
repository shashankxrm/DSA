package binaryTreeTraversal;
import java.util.*;
// LC94: Binary Tree Inorder Traversal
// Given a binary tree, return the inorder traversal of its nodes' values.
// Example: Input: root = [1,null,2,3] Output: [1,3,2]
// Example: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9] Output: [ 4,2,6,7,5,1,3,8,9]
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left; // Go to the leftmost node
            }
            current = stack.pop(); // Visit the node
            result.add(current.val); // Add to result
            current = current.right; // Go to the right subtree
        }
        return result;
    }
}
