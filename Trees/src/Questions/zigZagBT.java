package Questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// LC 103 : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
// (i.e., from left to right, then right to left for the next level and so on).
public class zigZagBT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }
}
