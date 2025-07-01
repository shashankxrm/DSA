package dfs;
import java.util.*;
// LC694: Number of Distinct Islands
// Given a 2D grid of 0s (land) and 1s (water), return the number of distinct islands.
// An island is a maximal 4-directionally connected group of 0s, and two islands are considered distinct if and only if
// they have different shapes or sizes, even if they are located in different positions in the grid.
// Example 1: Input: grid = [[1,1,0,0,0],[1,0,0,1,1],[0,0,0,1,0],[0,1,1,0,0]]
// Output: 3 Explanation: There are three distinct islands in the grid.
public class numOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) { // Time: O(m * n), Space: O(m * n)
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, visited, i, j, i, j, shape);
                    shapes.add(shape.toString());
                }
            }
        }
        return shapes.size();
    }
    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseI, int baseJ, StringBuilder shape) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 1) return;
        visited[i][j] = true;
        shape.append(i - baseI).append(',').append(j - baseJ).append(';'); // Record relative position
        dfs(grid, visited, i - 1, j, baseI, baseJ, shape); // up
        dfs(grid, visited, i + 1, j, baseI, baseJ, shape); // down
        dfs(grid, visited, i, j - 1, baseI, baseJ, shape); // left
        dfs(grid, visited, i, j + 1, baseI, baseJ, shape); // right
    }
}
