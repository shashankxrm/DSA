package BFS;
import java.util.*;

// LC102: Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
// level by level).
// Example 1: Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
public class BTlevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) { // Time: O(n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level); // result.add(0, level) to reverse the order
        }
        return result;
    }
}
