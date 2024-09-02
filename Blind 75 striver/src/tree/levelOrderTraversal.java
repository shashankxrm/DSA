package tree;

// LC 102 : Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:
// Input: root = [1]
// Output: [[1]]
// Example 3:
// Input: root = []
// Output: []


import java.util.LinkedList;
import java.util.List;

public class levelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) { // time : O(n), space : O(n)
        List<List<Integer>> res = new LinkedList<>();
        levelOrderTraversal(root, res, 0);
        return res;
    }

    private void levelOrderTraversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (level >= res.size()) {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            res.add(list);
        } else {
            List<Integer> list = res.get(level);
            list.add(root.val);
        }

        levelOrderTraversal(root.left, res, level + 1);
        levelOrderTraversal(root.right, res, level + 1);
    }

    public java.util.List<java.util.List<Integer>> levelOrder2(TreeNode root) { // time : O(n), space : O(n)
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        if(root == null) return res;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
