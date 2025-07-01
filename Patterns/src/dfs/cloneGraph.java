package dfs;
import java.util.*;
// LC133: Clone Graph
// Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List<Node>) of its neighbors.
// The graph is represented as an adjacency list.
// Example 1: Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
public class cloneGraph {
    public Node cloneGraph(Node node) { // Time: O(V + E), Space: O(V)
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node); // Return the cloned node if already cloned
        Node clone = new Node(node.val);
        map.put(node, clone); // Store the cloned node in the map
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map)); // Recursively clone neighbors
        }
        return clone;
    }
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
