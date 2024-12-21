import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    // adj list from graph figure
    // 1 -> {2, 6}
    // 2 -> {1, 3, 4}
    // 3 -> {2, 4, 5}
    // 4 -> {2, 3, 5, 6}
    // 5 -> {3, 4, 6}
    // 6 -> {1, 4, 5}

    //function to perform bfs
    public ArrayList<Integer> bfstraversal(int V, ArrayList<ArrayList<Integer>> adj) { // time: O(V + E), space: O(V)
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                bfs.add(i);
                visited[i] = true;
                for (int j : adj.get(i)) {
                    if (!visited[j]) {
                        bfs.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return bfs;
    }
    // function to perform bfs using queue
    public ArrayList<Integer> bfstraversalqueue(int V, ArrayList<ArrayList<Integer>> adj) { // time: O(V + E), space: O(V)
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);
            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return bfs;
    }
}
