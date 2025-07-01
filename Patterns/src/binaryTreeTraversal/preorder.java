package binaryTreeTraversal;
import java.util.*;
// LC144: Binary Tree Preorder Traversal
// Given a binary tree, return the preorder traversal of its nodes' values.
// Example: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9] Output: [1,2,4,5,6,7,3,8,9]
public class preorder {
    public List<Integer> preorderTraversal(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop(); // Visit the node
            result.add(current.val); // Add to result

            // Push right child first so that left child is processed next
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
