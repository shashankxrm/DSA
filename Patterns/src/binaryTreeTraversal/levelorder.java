package binaryTreeTraversal;
import java.util.*;
// LC102: Binary Tree Level Order Traversal
// Given a binary tree, return the level order traversal of its nodes' values.
// Example: Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
public class levelorder {
    public List<List<Integer>> levelOrder(TreeNode root) { // Time: O(n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
