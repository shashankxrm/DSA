package BFS;
import java.util.*;
// LC107: Binary Tree Level Order Traversal II
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
// level by level, but the last level comes first). This is the same as LC102 but with the order of levels reversed.
// Example 1: Input: root = [3,9,20,null,null,15,7] Output: [[15,7],[9,20],[3]]
public class BTlevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) { // Time: O(n), Space: O(n)
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
            result.add(0, level); // Add the current level at the beginning
        }
        return result;
    }
}
