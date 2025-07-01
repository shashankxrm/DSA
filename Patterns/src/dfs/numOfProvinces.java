package dfs;

// LC547: Number of Provinces
// Given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith and jth cities are directly connected,
// and isConnected[i][j] = 0 otherwise, return the total number of provinces.
// A province is a group of directly or indirectly connected cities, and no other cities outside of the group.
// Example 1: Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2 Explanation: The first and second cities are directly connected, while the third city is isolated.
public class numOfProvinces {
    public int findCircleNum(int[][] isConnected) { // Time: O(n^2), Space: O(n)
        if (isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length, count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true; // Mark the city as visited
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); // Visit connected cities
            }
        }
    }
}
