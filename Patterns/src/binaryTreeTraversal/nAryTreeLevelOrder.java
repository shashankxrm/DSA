package binaryTreeTraversal;
import java.util.*;
// LC429: N-ary Tree Level Order Traversal
// Given an n-ary tree, return the level order traversal of its nodes' values.
// Example: Input: root = [1,null,3,2,4,null,5,6] Output: [[1],[3,2,4],[5,6]]
public class nAryTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) { // Time: O(n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                for (Node child : currentNode.children) {
                    queue.offer(child);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
