package binaryTreeTraversal;
import java.util.*;
// LC103: Binary Tree Zigzag Level Order Traversal
// Given a binary tree, return the zigzag level order traversal of its nodes' values.
// Example: Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]]
public class zigzaglevelorder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { // Time: O(n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Flag to determine the order of traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // Add the node value based on the current order
                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val); // Add to the front for reverse order
                }
                // Add children to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle the order for the next level
        }
        return result;
    }
}
