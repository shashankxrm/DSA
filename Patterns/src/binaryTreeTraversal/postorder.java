package binaryTreeTraversal;
import java.util.*;
// LC145: Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.
// Example: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9] Output: [4,6,7,5,2,3,8,1]
public class postorder {
    public List<Integer> postorderTraversal(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> output = new Stack<>(); // To store the postorder traversal
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            output.push(current.val); // Push the node value to output stack

            // Push left child first so that right child is processed next
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        // Pop from output stack to get postorder traversal
        while (!output.isEmpty()) {
            result.add(output.pop());
        }
        return result;
    }
}
