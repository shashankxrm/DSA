package binaryTreeTraversal;
import java.util.*;
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


public class viewsOfBT {
    // Right View of Binary Tree
    public List<Integer> rightSideView(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == size - 1) { // Last node in the current level
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
    // Left View of Binary Tree
    public List<Integer> leftSideView(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0) { // First node in the current level
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
    // Top View of Binary Tree
    public List<Integer> topView(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> columnMap = new HashMap<>(); // Column index to node value
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // Pair of node and its column index
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.poll();
            TreeNode currentNode = currentPair.getKey();
            int columnIndex = currentPair.getValue();

            if (!columnMap.containsKey(columnIndex)) {
                columnMap.put(columnIndex, currentNode.val); // Store the first node in this column
            }

            if (currentNode.left != null) {
                queue.offer(new Pair<>(currentNode.left, columnIndex - 1));
                minColumn = Math.min(minColumn, columnIndex - 1);
            }
            if (currentNode.right != null) {
                queue.offer(new Pair<>(currentNode.right, columnIndex + 1));
                maxColumn = Math.max(maxColumn, columnIndex + 1);
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnMap.get(i));
        }
        return result;
    }
    // Bottom View of Binary Tree
    public List<Integer> bottomView(TreeNode root) { // Time: O(n), Space: O(n)
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> columnMap = new HashMap<>(); // Column index to node value
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // Pair of node and its column index
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.poll();
            TreeNode currentNode = currentPair.getKey();
            int columnIndex = currentPair.getValue();

            columnMap.put(columnIndex, currentNode.val); // Update the node value for this column

            if (currentNode.left != null) {
                queue.offer(new Pair<>(currentNode.left, columnIndex - 1));
                minColumn = Math.min(minColumn, columnIndex - 1);
            }
            if (currentNode.right != null) {
                queue.offer(new Pair<>(currentNode.right, columnIndex + 1));
                maxColumn = Math.max(maxColumn, columnIndex + 1);
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnMap.get(i));
        }
        return result;
    }





}
