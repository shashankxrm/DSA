import java.util.ArrayList;

public class dfs {
    // adj list from graph figure
    // 1 -> {2, 6}
    // 2 -> {1, 3, 4}
    // 3 -> {2, 4, 5}
    // 4 -> {2, 3, 5, 6}
    // 5 -> {3, 4, 6}
    // 6 -> {1, 4, 5}

    //function to perform dfs
    public void dfsTraversal(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) { // time: O(V + E), space: O(V)
        list.add(node);
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfsTraversal(i, visited, adj, list);
            }
        }
    }
    public ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj) { // time: O(V + E), space: O(V)
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfsTraversal(i, visited, adj, dfs);
            }
        }
        return dfs;
    }

}
