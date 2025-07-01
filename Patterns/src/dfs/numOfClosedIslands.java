package dfs;

// LC1254: Number of Closed Islands
// Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4-directionally connected group of 0s
// and a closed island is an island totally surrounded by 1s. Return the number of closed islands.
// Example 1: Input: grid = [[1,1,1,1,0,1],[1,0,0,0,0,1],[1,0,1,0,1,1],[1,0,0,0,0,1],[1,1,1,1,0,1]]
// Output: 1 Explanation: There is one closed island in the grid.
public class numOfClosedIslands {
    public int closedIsland(int[][] grid) { // Time: O(m * n), Space: O(m * n)
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false; // Out of bounds
        if (grid[i][j] == 1) return true; // Water cell
        if (visited[i][j]) return true; // Already visited
        visited[i][j] = true; // Mark as visited
        boolean up = dfs(grid, visited, i - 1, j); // up
        boolean down = dfs(grid, visited, i + 1, j); // down
        boolean left = dfs(grid, visited, i, j - 1); // left
        boolean right = dfs(grid, visited, i, j + 1); // right
        return up && down && left && right; // Return true if all directions are valid
    }
}
